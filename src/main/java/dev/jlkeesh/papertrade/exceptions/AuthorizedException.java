package dev.jlkeesh.papertrade.exceptions;

public class AuthorizedException extends RuntimeException {
    public AuthorizedException(String message) {
        super(message);
    }

    public AuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
