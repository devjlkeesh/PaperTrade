package dev.jlkeesh.papertrade.exceptions;

import dev.jlkeesh.papertrade.enums.ErrorCode;


public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
