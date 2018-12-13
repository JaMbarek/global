package com.cloud.mvc.example.business.domain.exceptions.user;

public class LoginException extends RuntimeException{

    private String message;

    public static LoginException instance(String message){
        LoginException e = new LoginException();
        e.message = message;
        return e;
    }

    public void doThrow(){
        throw this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
