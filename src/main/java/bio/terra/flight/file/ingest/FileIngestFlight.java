package bio.terra.flight.file.ingest;

import bio.terra.stairway.UserRequestInfo;
import bio.terra.filesystem.FireStoreFileDao;
import bio.terra.metadata.Dataset;
import bio.terra.pdao.gcs.GcsPdao;
import bio.terra.resourcemanagement.service.ProfileService;
import bio.terra.service.FileService;
import bio.terra.service.JobMapKeys;
import bio.terra.service.DatasetService;
import bio.terra.service.dataproject.DataLocationService;
import bio.terra.stairway.Flight;
import bio.terra.stairway.FlightMap;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.UUID;

public class FileIngestFlight extends Flight {

    public FileIngestFlight(FlightMap inputParameters, Object applicationContext, UserRequestInfo userRequestInfo) {
        super(inputParameters, applicationContext, userRequestInfo);

        ApplicationContext appContext = (ApplicationContext) applicationContext;
        FireStoreFileDao fileDao = (FireStoreFileDao)appContext.getBean("fireStoreFileDao");
        FileService fileService = (FileService)appContext.getBean("fileService");
        GcsPdao gcsPdao = (GcsPdao)appContext.getBean("gcsPdao");
        DatasetService datasetService = (DatasetService)appContext.getBean("datasetService");
        ProfileService profileService = (ProfileService)appContext.getBean("profileService");
        DataLocationService locationService = (DataLocationService)appContext.getBean("dataLocationService");

        // get data from inputs that steps need
        Map<String, String> pathParams = (Map<String, String>) inputParameters.get(
            JobMapKeys.PATH_PARAMETERS.getKeyName(), Map.class);
        UUID datasetId = UUID.fromString(pathParams.get(JobMapKeys.DATASET_ID.getKeyName()));
        Dataset dataset = datasetService.retrieve(datasetId);

        // The flight plan:
        // 1. Metadata step:
        //    Compute the target gspath where the file should go
        //    Create the file object in the database; marked as not present
        // 2. locate the bucket where this file should go and store it in the working map
        // 3. pdao does the file copy and returns file gspath, checksum and size
        // 4. Update the file object with the gspath, checksum and size and mark as present
        addStep(new IngestFileMetadataStepStart(fileDao, dataset, profileService));
        addStep(new IngestFilePrimaryDataLocationStep(fileDao, dataset, locationService));
        addStep(new IngestFilePrimaryDataStep(fileDao, dataset, gcsPdao));
        addStep(new IngestFileMetadataStepComplete(fileDao, fileService, dataset));
    }

}
