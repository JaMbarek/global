package com.cloud.mvc.example.business.domain.exceptions;

public abstract class IThrow extends RuntimeException {

    public IThrow() {
    }

    public IThrow(String message) {
        super(message);
    }

    public IThrow(String message, Throwable cause) {
        super(message, cause);
    }

    public IThrow(Throwable cause) {
        super(cause);
    }

    public IThrow(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public void doThrow(){
        throw this;
    }


}
