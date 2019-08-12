package bio.terra.flight.dataset.create;

import bio.terra.stairway.FlightMap;

public class UndoDatasetCreateFlight extends DatasetCreateFlight {

    public UndoDatasetCreateFlight(FlightMap inputParameters, Object applicationContext) {
        super(inputParameters, applicationContext);
        addStep(new TriggerUndoStep());
    }
}