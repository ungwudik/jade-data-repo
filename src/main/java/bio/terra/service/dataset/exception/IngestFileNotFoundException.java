package bio.terra.service.dataset.exception;

import bio.terra.common.exception.NotFoundException;

public class IngestFileNotFoundException extends NotFoundException {
    public IngestFileNotFoundException(String message) {
        super(message);
    }

    public IngestFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngestFileNotFoundException(Throwable cause) {
        super(cause);
    }
}
