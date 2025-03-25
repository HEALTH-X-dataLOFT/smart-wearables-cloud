package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.exception;

public class RequestFailedException extends IllegalArgumentException {

    public RequestFailedException(String message) {
        super(message);
    }

    public RequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
