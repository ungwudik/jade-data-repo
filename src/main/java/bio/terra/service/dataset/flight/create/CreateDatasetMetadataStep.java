package bio.terra.service.dataset.flight.create;

import bio.terra.service.dataset.DatasetDao;
import bio.terra.service.dataset.exception.InvalidDatasetException;
import bio.terra.service.dataset.DatasetUtils;
import bio.terra.service.dataset.flight.DatasetWorkingMapKeys;
import bio.terra.service.dataset.Dataset;
import bio.terra.service.dataset.DatasetJsonConversion;
import bio.terra.model.DatasetRequestModel;
import bio.terra.model.DatasetSummaryModel;
import bio.terra.service.job.JobMapKeys;
import bio.terra.stairway.FlightContext;
import bio.terra.stairway.FlightMap;
import bio.terra.stairway.Step;
import bio.terra.stairway.StepResult;
import bio.terra.stairway.StepStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;


public class CreateDatasetMetadataStep implements Step {

    private DatasetDao datasetDao;
    private DatasetRequestModel datasetRequest;

    private static Logger logger = LoggerFactory.getLogger(CreateDatasetMetadataStep.class);

    public CreateDatasetMetadataStep(DatasetDao datasetDao, DatasetRequestModel datasetRequest) {
        this.datasetDao = datasetDao;
        this.datasetRequest = datasetRequest;
    }

    @Override
    public StepResult doStep(FlightContext context) {
        try {
            Dataset newDataset = DatasetUtils.convertRequestWithGeneratedNames(datasetRequest);
            UUID datasetId = datasetDao.createAndLock(newDataset, context.getFlightId());
            FlightMap workingMap = context.getWorkingMap();
            workingMap.put(DatasetWorkingMapKeys.DATASET_ID, datasetId);

            DatasetSummaryModel datasetSummary =
                DatasetJsonConversion.datasetSummaryModelFromDatasetSummary(newDataset.getDatasetSummary());
            workingMap.put(JobMapKeys.RESPONSE.getKeyName(), datasetSummary);
            return StepResult.getStepResultSuccess();
        } catch (InvalidDatasetException idEx) {
            return new StepResult(StepStatus.STEP_RESULT_FAILURE_FATAL, idEx);
        } catch (Exception ex) {
            return new StepResult(StepStatus.STEP_RESULT_FAILURE_FATAL,
                new InvalidDatasetException("Cannot create dataset: " + datasetRequest.getName(), ex));
        }
    }

    @Override
    public StepResult undoStep(FlightContext context) {
        logger.debug("Dataset creation failed. Deleting metadata.");
        datasetDao.deleteByNameAndFlight(datasetRequest.getName(), context.getFlightId());
        return StepResult.getStepResultSuccess();
    }
}

