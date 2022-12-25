package com.verify.demo.exception;

import com.verify.demo.response.PasswordApiResponse;

public class PasswordException extends RuntimeException {
    
    private final PasswordApiResponse faultResponse;
    private final Exception exception;

    public PasswordException(PasswordApiResponse faultResponse, Exception exception) {
        this.faultResponse = faultResponse;
        this.exception = exception;
    }

    public PasswordApiResponse getFaultResponse() {
        return faultResponse;
    }

    public Exception getException() {
        return exception;
    }
}
