package bio.terra.service.filedata.google.gcs;

import bio.terra.common.ProcessUtils;
import bio.terra.service.configuration.ConfigEnum;
import bio.terra.service.configuration.ConfigurationService;
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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Profile("google")
public class GcsPdao {
    private static final Logger logger = LoggerFactory.getLogger(GcsPdao.class);
    private static final int DATASET_DELETE_BATCH_SIZE = 1000;

    private final GcsProjectFactory gcsProjectFactory;
    private final DataLocationService dataLocationService;
    private final FireStoreDao fileDao;
    private final ConfigurationService configService;

    @Autowired
    public GcsPdao(
        GcsProjectFactory gcsProjectFactory,
        DataLocationService dataLocationService,
        FireStoreDao fileDao,
        ConfigurationService configService) {
        this.gcsProjectFactory = gcsProjectFactory;
        this.dataLocationService = dataLocationService;
        this.fileDao = fileDao;
        this.configService = configService;
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
            // a config parameter controls the file copy method
            boolean fileCopyUseJavaClient = configService.getParameterValue(ConfigEnum.FILE_COPY_USE_JAVA_CLIENT);
            logger.debug("FILE_COPY_USE_JAVA_CLIENT = " + fileCopyUseJavaClient);

//            Blob targetBlob;
//            if (fileCopyUseJavaClient) {
//                // FILE_COPY_USE_JAVA_CLIENT = true. use the Java client library
//                targetBlob = copyFileJavaClient(storage, sourceBlob, targetPath, bucketResource);
//            } else {
//                // FILE_COPY_USE_JAVA_CLIENT = false (default). use gsutil
//                copyFileGsutil(sourceBlob, targetPath, bucketResource);
//
//                // fetch the copied blob
//                targetBlob = storage.get(bucketResource.getName(), targetPath,
//                    Storage.BlobGetOption.fields(Storage.BlobField.values()));
//            }

            long startTime = System.currentTimeMillis();
            copyFileJavaClient(storage, sourceBlob, targetPath, bucketResource, null);
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("javaClient,default,"
                + sourceBlob.getBucket() + "/" + sourceBlob.getName() + ","
                + sourceBlob.getSize() + "," + elapsedTime);

            startTime = System.currentTimeMillis();
            copyFileJavaClient(storage, sourceBlob, targetPath, bucketResource, Long.valueOf(1500));
            elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("javaClient,1500,"
                + sourceBlob.getBucket() + "/" + sourceBlob.getName() + ","
                + sourceBlob.getSize() + "," + elapsedTime);

            startTime = System.currentTimeMillis();
            Blob targetBlob = copyFileJavaClient(storage, sourceBlob, targetPath, bucketResource, Long.valueOf(100000));
            elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("javaClient,100000,"
                + sourceBlob.getBucket() + "/" + sourceBlob.getName() + ","
                + sourceBlob.getSize() + "," + elapsedTime);

//            startTime = System.currentTimeMillis();
//            copyFileGsutil(sourceBlob, targetPath, bucketResource);
//            Blob targetBlob = storage.get(bucketResource.getName(), targetPath,
//                Storage.BlobGetOption.fields(Storage.BlobField.values()));
//            elapsedTime = System.currentTimeMillis() - startTime;
//            System.out.println("gsutil,,"
//                + sourceBlob.getBucket() + "/" + sourceBlob.getName() + ","
//                + sourceBlob.getSize() + "," + elapsedTime);

            if (!fileCopyUseJavaClient) {
                throw new RuntimeException("mariko end flight post-copy");
            }

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

    private Blob copyFileJavaClient(Storage storage,
                                    Blob sourceBlob,
                                    String targetPath,
                                    GoogleBucketResource bucketResource,
                                    Long chunkSizeMB) {
        if (chunkSizeMB == null) {
            Storage.CopyRequest request =
                Storage.CopyRequest.newBuilder()
                    .setSource(sourceBlob.getBlobId())
                    .setTarget(BlobId.of(bucketResource.getName(), targetPath))
                    .build();
            CopyWriter copyWriter = storage.copy(request);
            return copyWriter.getResult();
        } else {
            Storage.CopyRequest request =
                Storage.CopyRequest.newBuilder()
                    .setSource(sourceBlob.getBlobId())
                    .setTarget(BlobId.of(bucketResource.getName(), targetPath))
                    .setMegabytesCopiedPerChunk(chunkSizeMB)
                    .build();
            CopyWriter copyWriter = storage.copy(request);
            return copyWriter.getResult();
        }
    }

    private void copyFileGsutil(Blob sourceBlob,
                                String targetPath,
                                GoogleBucketResource bucketResource) throws URISyntaxException {
        try {
            URI sourceUri = new URI("gs",
                sourceBlob.getBucket(),
                "/" + sourceBlob.getName(),
                null,
                null);
            URI targetUri = new URI("gs",
                bucketResource.getName(),
                "/" + targetPath,
                null,
                null);

            List<String> args = new ArrayList<>();
            args.add("cp");
            args.add(sourceUri.toString());
            args.add(targetUri.toString());
            List<String> cmdResponse = ProcessUtils.executeCommand("gsutil", args);

            // do something if there are any output lines -- I don't think that's expected from gsutil cp
        } catch (IOException ioEx) {
            throw new PdaoException("gsutil call to copy file failed", ioEx);
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
