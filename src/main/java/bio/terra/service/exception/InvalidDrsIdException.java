package bio.terra.service.exception;

import bio.terra.exception.BadRequestException;

public class InvalidDrsIdException extends BadRequestException {
    public InvalidDrsIdException(String message) {
        super(message);
    }

    public InvalidDrsIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDrsIdException(Throwable cause) {
        super(cause);
    }
}