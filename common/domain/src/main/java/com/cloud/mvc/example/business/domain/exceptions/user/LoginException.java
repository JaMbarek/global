package com.cloud.mvc.example.business.domain.exceptions.user;

import com.cloud.mvc.example.business.domain.exceptions.IMessage;
import com.cloud.mvc.example.business.domain.exceptions.IThrow;

public class LoginException extends IThrow implements IMessage {

    private String message;

    public static LoginException instance(String message){
        LoginException e = new LoginException();
        e.message = message;
        return e;
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

    @Override
    public String getDescription() {
        return "登录过程发生异常";
    }
}
