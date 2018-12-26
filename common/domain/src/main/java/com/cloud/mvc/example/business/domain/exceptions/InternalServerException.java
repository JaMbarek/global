package com.cloud.mvc.example.business.domain.exceptions;

import com.google.common.base.Strings;

/**
 *
 */
public class InternalServerException extends IThrow implements IMessage{

    private String message;

    public static InternalServerException instance(String message){
         InternalServerException e = new InternalServerException();
         e.message = Strings.isNullOrEmpty(message) ? e.getDescription() : message;
         return e;
    }

    public InternalServerException() {
    }

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }

    public InternalServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getDescription() {
        return "内部服务调用发生异常";
    }
}
