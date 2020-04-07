package bio.terra.service.filedata.google.gcs;

import bio.terra.common.HttpUtils;
import bio.terra.common.ProcessUtils;
import bio.terra.service.filedata.google.firestore.FireStoreDao;
import bio.terra.service.filedata.google.firestore.FireStoreFile;
import bio.terra.service.dataset.Dataset;
import bio.terra.service.filedata.FSFile;
import bio.terra.service.filedata.FSFileInfo;
import bio.terra.service.filedata.FSItem;
import bio.terra.model.FileLoadModel;
import bio.terra.common.exception.PdaoException;
import bio.terra.common.exception.PdaoFileCopyException;
import bio.terra.common.exception.PdaoInvalidUriException;
import bio.terra.common.exception.PdaoSourceFileNotFoundException;
import bio.terra.service.iam.AuthenticatedUserRequest;
import bio.terra.service.resourcemanagement.google.GoogleBucketResource;
import bio.terra.service.resourcemanagement.google.GoogleProjectResource;
import bio.terra.service.resourcemanagement.DataLocationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("google")
public class GcsPdao {
    private static final Logger logger = LoggerFactory.getLogger(GcsPdao.class);
    private static final int DATASET_DELETE_BATCH_SIZE = 1000;

    private final GcsProjectFactory gcsProjectFactory;
    private final DataLocationService dataLocationService;
    private final FireStoreDao fileDao;

    @Autowired
    public GcsPdao(
        GcsProjectFactory gcsProjectFactory,
        DataLocationService dataLocationService,
        FireStoreDao fileDao) {
        this.gcsProjectFactory = gcsProjectFactory;
        this.dataLocationService = dataLocationService;
        this.fileDao = fileDao;
    }

    private Storage storageForBucket(GoogleBucketResource bucketResource) {
        GoogleProjectResource projectResource = bucketResource.getProjectResource();
        GcsProject gcsProject = gcsProjectFactory.get(projectResource.getGoogleProjectId());
        return gcsProject.getStorage();
    }

    public FSFileInfo copyFile(Dataset dataset,
                               FileLoadModel fileLoadModel,
                               String fileId,
                               GoogleBucketResource bucketResource,
                               AuthenticatedUserRequest userReq) {


        Storage storage = storageForBucket(bucketResource);
        Blob sourceBlob = getBlobFromGsPath(storage, fileLoadModel.getSourcePath());

        // Our path is /<dataset-id>/<file-id>
        String targetPath = dataset.getId().toString() + "/" + fileId;

        try {
//            if (description.equals("javaHttp")) {
//                System.out.println("javaHttp");
//                try {
//                    // https://storage.googleapis.com/storage/v1/b/[SOURCE_BUCKET_NAME]/
//                    // o/[SOURCE_OBJECT_NAME]/rewriteTo/b/[DESTINATION_BUCKET_NAME]/o/[DESTINATION_OBJECT_NAME]
//                    String sourceObjectName = URLEncoder.encode(sourceBlob.getName(),"UTF-8");
//                    String targetObjectName = URLEncoder.encode(targetPath, "UTF-8");
//                    String urlStr = "https://storage.googleapis.com/storage/v1" +
//                        "/b/" + sourceBlob.getBucket() + "/o/" + sourceObjectName +
//                        "/rewriteTo/b/" + bucketResource.getName() + "/o/" + targetObjectName;
//                    System.out.println("urlStr = " + urlStr);
//                    //String accessToken = userReq.getRequiredToken();
//                    GoogleCredential credential = GoogleCredential.getApplicationDefault();
//                    if (credential.createScopedRequired()) {
//                        credential = credential.createScoped(
//                            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
//                    }
//                    credential.getRefreshToken();
//                    Map<String, Object> javaHttpResponse =
//                        HttpUtils.sendJavaHttpRequest(urlStr, "POST", credential.getAccessToken(), null);
//                    logger.info("statusCode: " + javaHttpResponse.get("statusCode"));
//                } catch (IOException ioEx) {
//                    System.out.println("ioEx caught: " + ioEx.getMessage());
//                    logger.error("javaHttp IOException", ioEx);
//                    throw new RuntimeException("mariko javaHttp failed");
//                }
//            }

            long startTime = System.currentTimeMillis();
            copyFileGsutil(sourceBlob, targetPath, bucketResource);
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("gsutil elapsedTime = " + elapsedTime);

            startTime = System.currentTimeMillis();
            copyFileJavaClient(sourceBlob, targetPath, bucketResource);
            elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("javaclient elapsedTime = " + elapsedTime);

            Blob targetBlob = storage.get(bucketResource.getName(), targetPath,
                Storage.BlobGetOption.fields(Storage.BlobField.values()));

            // MD5 is computed per-component. So if there are multiple components, the MD5 here is
            // not useful for validating the contents of the file on access. Therefore, we only
            // return the MD5 if there is only a single component. For more details,
            // see https://cloud.google.com/storage/docs/hashes-etags
            Integer componentCount = targetBlob.getComponentCount();
            String checksumMd5 = null;
            if (componentCount == null || componentCount == 1) {
                checksumMd5 = targetBlob.getMd5ToHexString();
            }

            // Grumble! It is not documented what the meaning of the Long is.
            // From poking around I think it is a standard POSIX milliseconds since Jan 1, 1970.
            Instant createTime = Instant.ofEpochMilli(targetBlob.getCreateTime());

            URI gspath = new URI("gs",
                bucketResource.getName(),
                "/" + targetPath,
                null,
                null);

            FSFileInfo fsFileInfo = new FSFileInfo()
                .fileId(fileId)
                .createdDate(createTime.toString())
                .gspath(gspath.toString())
                .checksumCrc32c(targetBlob.getCrc32cToHexString())
                .checksumMd5(checksumMd5)
                .size(targetBlob.getSize())
                .bucketResourceId(bucketResource.getResourceId().toString());

            return fsFileInfo;
        } catch (StorageException ex) {
            // For now, we assume that the storage exception is caused by bad input (the file copy exception
            // derives from BadRequestException). I think there are several cases here. We might need to retry
            // for flaky google case or we might need to bail out if access is denied.
            throw new PdaoFileCopyException("File ingest failed", ex);
        } catch (URISyntaxException ex) {
            throw new PdaoException("Bad URI of our own making", ex);
        }
    }

    private void copyFileJavaClient(Blob sourceBlob,
                                    String targetPath,
                                    GoogleBucketResource bucketResource) {
        // I have been seeing timeouts and I think they are due to particularly large files,
        // so I changed exported the timeouts to application.properties to allow for tuning
        CopyWriter writer = sourceBlob.copyTo(BlobId.of(bucketResource.getName(), targetPath));
        while (!writer.isDone()) {
            writer.copyChunk();
        }
        writer.getResult();
    }

    private void copyFileGsutil(Blob sourceBlob,
                                String targetPath,
                                GoogleBucketResource bucketResource) throws URISyntaxException {
        try {
            URI targetUri = new URI("gs",
                bucketResource.getName(),
                "/" + targetPath,
                null,
                null);

            List<String> args = new ArrayList<>();
            args.add("cp");
            args.add(sourceBlob.getSelfLink());
            args.add(targetUri.toString());
            List<String> cmdResponse = ProcessUtils.executeCommand("gsutil", args);

            // do something if there are any output lines -- I don't think that's expected from gsutil cp
        } catch (IOException ioEx) {
            System.out.println("exception caught: " + ioEx.getMessage());
            logger.error("gsutil IOException", ioEx);
            throw new RuntimeException("mariko gsutil failed");
        }
    }

    // Three flavors of deleteFileMetadata
    // 1. for undo file ingest - it gets the bucket path from the dataset and file id
    // 2. for delete file flight - it gets bucket path from the gspath
    // 3. for delete file consumer for deleting all files - it gets bucket path
    //    from gspath in the fireStoreFile

    public boolean deleteFileById(Dataset dataset,
                                  String fileId,
                                  GoogleBucketResource bucketResource) {
        String bucketPath = dataset.getId().toString() + "/" + fileId;
        return deleteWorker(bucketResource, bucketPath);
    }

    public boolean deleteFileByGspath(String inGspath, GoogleBucketResource bucketResource) {
        if (inGspath != null) {
            URI uri = URI.create(inGspath);
            String bucketPath = StringUtils.removeStart(uri.getPath(), "/");
            return deleteWorker(bucketResource, bucketPath);
        }
        return false;
    }

    // Consumer method for deleting GCS files driven from a scan over the firestore files
    public void deleteFile(FireStoreFile fireStoreFile) {
        if (fireStoreFile != null) {
            GoogleBucketResource bucketResource = dataLocationService.lookupBucket(fireStoreFile.getBucketResourceId());
            deleteFileByGspath(fireStoreFile.getGspath(), bucketResource);
        }
    }

    private boolean deleteWorker(GoogleBucketResource bucketResource, String bucketPath) {
        GcsProject gcsProject = gcsProjectFactory.get(bucketResource.getProjectResource().getGoogleProjectId());
        Storage storage = gcsProject.getStorage();
        Optional<Blob> blob = Optional.ofNullable(storage.get(BlobId.of(bucketResource.getName(), bucketPath)));
        if (blob.isPresent()) {
            return blob.get().delete();
        }
        return false;
    }

    private enum AclOp {
        ACL_OP_CREATE,
        ACL_OP_DELETE
    };

    public void setAclOnFiles(Dataset dataset, List<String> fileIds, String readersPolicyEmail) {
        fileAclOp(AclOp.ACL_OP_CREATE, dataset, fileIds, readersPolicyEmail);
    }

    public void removeAclOnFiles(Dataset dataset, List<String> fileIds, String readersPolicyEmail) {
        fileAclOp(AclOp.ACL_OP_DELETE, dataset, fileIds, readersPolicyEmail);
    }

    static Blob getBlobFromGsPath(Storage storage, String gspath) {
        String sourceBucket;
        String sourcePath;

        try {
            URI sourceUri = URI.create(gspath);
            if (!StringUtils.equals(sourceUri.getScheme(), "gs")) {
                throw new PdaoInvalidUriException("Path is not a gs path: '" + gspath + "'");
            }
            if (sourceUri.getPort() != -1) {
                throw new PdaoInvalidUriException("Path must not have a port specified: '" + gspath + "'");
            }
            sourceBucket = sourceUri.getAuthority();
            sourcePath = StringUtils.removeStart(sourceUri.getPath(), "/");
        } catch (IllegalArgumentException ex) {
            throw new PdaoInvalidUriException("Invalid gs path: '" + gspath + "'", ex);
        }

        if (sourceBucket == null || sourcePath == null) {
            throw new PdaoInvalidUriException("Invalid gs path: '" + gspath + "'");
        }

        Blob sourceBlob = storage.get(BlobId.of(sourceBucket, sourcePath));
        if (sourceBlob == null) {
            throw new PdaoSourceFileNotFoundException("Source file not found: '" + gspath + "'");
        }

        return sourceBlob;
    }

    private void fileAclOp(AclOp op, Dataset dataset, List<String> fileIds, String readersPolicyEmail) {
        Acl.Group readerGroup = new Acl.Group(readersPolicyEmail);
        Acl acl = Acl.newBuilder(readerGroup, Acl.Role.READER).build();

        for (String fileId : fileIds) {
            FSItem fsItem = fileDao.retrieveById(dataset, fileId, 0, true);
            if (fsItem instanceof FSFile) {
                FSFile fsFile = (FSFile) fsItem;
                GoogleBucketResource bucketForFile = dataLocationService.lookupBucket(fsFile.getBucketResourceId());
                Storage storage = storageForBucket(bucketForFile);
                URI gsUri = URI.create(fsFile.getGspath());
                String bucketPath = StringUtils.removeStart(gsUri.getPath(), "/");
                BlobId blobId = BlobId.of(bucketForFile.getName(), bucketPath);
                switch (op) {
                    case ACL_OP_CREATE:
                        storage.createAcl(blobId, acl);
                        break;
                    case ACL_OP_DELETE:
                        storage.deleteAcl(blobId, readerGroup);
                        break;
                }
            }
        }
    }
}
