package bio.terra.service.dataset.flight.datadelete;

import bio.terra.service.dataset.DatasetDao;
import bio.terra.service.dataset.DatasetService;
import bio.terra.service.dataset.flight.LockDatasetStep;
import bio.terra.service.dataset.flight.UnlockDatasetStep;
import bio.terra.service.iam.IamAction;
import bio.terra.service.iam.IamResourceType;
import bio.terra.service.iam.IamService;
import bio.terra.service.iam.flight.VerifyAuthorizationStep;
import bio.terra.service.job.JobMapKeys;
import bio.terra.service.tabulardata.google.BigQueryPdao;
import bio.terra.stairway.Flight;
import bio.terra.stairway.FlightMap;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

public class DatasetDataDeleteFlight extends Flight {

    public DatasetDataDeleteFlight(FlightMap inputParameters, Object applicationContext) {
        super(inputParameters, applicationContext);

        // get the required daos and services to pass into the steps
        ApplicationContext appContext = (ApplicationContext) applicationContext;
        DatasetDao datasetDao = (DatasetDao) appContext.getBean("datasetDao");
        DatasetService datasetService = (DatasetService) appContext.getBean("datasetService");
        BigQueryPdao bigQueryPdao = (BigQueryPdao) appContext.getBean("bigQueryPdao");
        IamService iamClient = (IamService) appContext.getBean("iamService");

        // get data from inputs that steps need
        String datasetId = inputParameters.get(JobMapKeys.DATASET_ID.getKeyName(), String.class);

        addStep(new VerifyAuthorizationStep(
            iamClient,
            IamResourceType.DATASET,
            datasetId,
            IamAction.UPDATE_DATA));

        // need to lock, need dataset name and flight id
        addStep(new LockDatasetStep(datasetDao, UUID.fromString(datasetId), false));

        // validate tables exist, check access to files, and create external temp tables
        addStep(new CreateExternalTablesStep(bigQueryPdao, datasetService));

        // insert into soft delete table
        addStep(new DataDeletionStep(bigQueryPdao, datasetService));

        // unlock
        addStep(new UnlockDatasetStep(datasetDao, UUID.fromString(datasetId), false));

        // cleanup
        addStep(new DropExternalTablesStep(bigQueryPdao, datasetService));
    }

}
