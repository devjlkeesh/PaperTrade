package dev.jlkeesh.papertrade.exceptions;

import dev.jlkeesh.papertrade.enums.ErrorCode;

/**
 * @author : Elmurodov Javohir
 * @since : 02/06/23 / 18:01
 */

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException() {
        super(ErrorCode.NOT_FOUND );
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
