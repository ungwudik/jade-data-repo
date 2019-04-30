package bio.terra.service;

import bio.terra.dao.DatasetDao;
import bio.terra.dao.StudyDao;
import bio.terra.filesystem.FileDao;
import bio.terra.filesystem.exception.FileSystemObjectNotFoundException;
import bio.terra.filesystem.exception.InvalidFileSystemObjectTypeException;
import bio.terra.flight.file.delete.FileDeleteFlight;
import bio.terra.flight.file.ingest.FileIngestFlight;
import bio.terra.metadata.FSObject;
import bio.terra.model.DRSAccessMethod;
import bio.terra.model.DRSAccessURL;
import bio.terra.model.DRSChecksum;
import bio.terra.model.DRSObject;
import bio.terra.model.FileLoadModel;
import bio.terra.model.FileModel;
import bio.terra.pdao.gcs.GcsConfiguration;
import bio.terra.stairway.FlightMap;
import bio.terra.stairway.Stairway;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class FileService {
    private final Logger logger = LoggerFactory.getLogger("bio.terra.service.FileService");

    private final Stairway stairway;
    private final StudyDao studyDao;
    private final DatasetDao datasetDao;
    private final FileDao fileDao;
    private final GcsConfiguration gcsConfiguration;

    @Autowired
    public FileService(Stairway stairway,
                       StudyDao studyDao,
                       DatasetDao datasetDao,
                       FileDao fileDao,
                       GcsConfiguration gcsConfiguration) {
        this.stairway = stairway;
        this.studyDao = studyDao;
        this.datasetDao = datasetDao;
        this.fileDao = fileDao;
        this.gcsConfiguration = gcsConfiguration;
    }

    public String deleteFile(String studyId, String fileId) {
        FlightMap flightMap = new FlightMap();
        flightMap.put(JobMapKeys.DESCRIPTION.getKeyName(), "Delete file from study " + studyId + " file " + fileId);
        flightMap.put(JobMapKeys.STUDY_ID.getKeyName(), studyId);
        flightMap.put(JobMapKeys.REQUEST.getKeyName(), fileId);
        return stairway.submit(FileDeleteFlight.class, flightMap);
    }

    public String ingestFile(String studyId, FileLoadModel fileLoad) {
        FlightMap flightMap = new FlightMap();
        flightMap.put(JobMapKeys.DESCRIPTION.getKeyName(), "Ingest file " + fileLoad.getTargetPath());
        flightMap.put(JobMapKeys.STUDY_ID.getKeyName(), studyId);
        flightMap.put(JobMapKeys.REQUEST.getKeyName(), fileLoad);
        return stairway.submit(FileIngestFlight.class, flightMap);
    }

    public FSObject lookupFSObject(String studyId, String fileId) {
        FSObject fsObject = fileDao.retrieveFile(UUID.fromString(fileId));

        if (!StringUtils.equals(fsObject.getStudyId().toString(), studyId)) {
            throw new FileSystemObjectNotFoundException("File with id '" + fileId + "' not found in study with id '"
                + studyId + "'");
        }

        switch (fsObject.getObjectType()) {
            case FILE:
                return fsObject;

            case DIRECTORY:
                throw new InvalidFileSystemObjectTypeException("Attempt to lookup a directory");

                // Don't show files that are coming or going
            case INGESTING_FILE:
            case DELETING_FILE:
            default:
                throw new FileSystemObjectNotFoundException("File with id '" + fileId + "' not found in study with id '"
                    + studyId + "'");
        }
    }

    public FileModel lookupFile(String studyId, String fileId) {
        return fileModelFromFSObject(lookupFSObject(studyId, fileId));
    }

    public DRSObject lookupDrsObject(String studyId, String fileId) {
        return drsObjectFromFSObject(lookupFSObject(studyId, fileId));
    }

    public FileModel fileModelFromFSObject(FSObject fsObject) {
        FileModel fileModel = new FileModel()
            .fileId(fsObject.getObjectId().toString())
            .studyId(fsObject.getStudyId().toString())
            .path(fsObject.getPath())
            .size(fsObject.getSize())
            .created(fsObject.getCreatedDate().toString())
            .mimeType(fsObject.getMimeType())
            .checksums(makeChecksums(fsObject))
            .accessUrl(fsObject.getGspath())
            .description(fsObject.getDescription());

        return fileModel;
    }

    // TODO: fix this: a dataset is required. This wont' work coming from the FSObject.
    public DRSObject drsObjectFromFSObject(FSObject fsObject) {
        // Compute the time once; used for both created and updated times as per DRS spec for immutable objects
        OffsetDateTime theTime = OffsetDateTime.ofInstant(fsObject.getCreatedDate(), ZoneId.of("Z"));

        DRSAccessURL accessURL = new DRSAccessURL()
            .url(fsObject.getGspath());

        DRSAccessMethod accessMethod = new DRSAccessMethod()
            .type(DRSAccessMethod.TypeEnum.GS)
            .accessUrl(accessURL)
            .region(gcsConfiguration.getRegion());

        DrsId drsId = DrsId.builder()
            .studyId(fsObject.getStudyId().toString())
            .datasetId("dataset")
            .fsObjectId(fsObject.getObjectId().toString())
            .build();

        DRSObject fileModel = new DRSObject()
            .id(drsId.toDrsObjectId())
            .name(getLastNameFromPath(fsObject.getPath()))
            .size(fsObject.getSize())
            .created(theTime)
            .updated(theTime)
            .version("1")
            .mimeType(fsObject.getMimeType())
            .checksums(makeChecksums(fsObject))
            .accessMethods(Collections.singletonList(accessMethod))
            .description(fsObject.getDescription())
            .aliases(Collections.singletonList(fsObject.getGspath()));

        return fileModel;
    }

    private List<DRSChecksum> makeChecksums(FSObject fsObject) {
        List<DRSChecksum> checksums = new ArrayList<>();
        DRSChecksum checksumCrc32 = new DRSChecksum()
            .checksum(fsObject.getChecksumCrc32c())
            .type("crc32c");
        checksums.add(checksumCrc32);

        if (fsObject.getChecksumMd5() != null) {
            DRSChecksum checksumMd5 = new DRSChecksum()
                .checksum(fsObject.getChecksumMd5())
                .type("md5");
            checksums.add(checksumMd5);
        }

        return checksums;
    }

    private String getLastNameFromPath(String path) {
        String[] pathParts = StringUtils.split(path, '/');
        return pathParts[pathParts.length - 1];
    }

}