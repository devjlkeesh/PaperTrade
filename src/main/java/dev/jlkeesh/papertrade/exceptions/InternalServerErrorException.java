package dev.jlkeesh.papertrade.exceptions;

import dev.jlkeesh.papertrade.enums.ErrorCode;


public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(String message) {
        super(message);
    }
    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
