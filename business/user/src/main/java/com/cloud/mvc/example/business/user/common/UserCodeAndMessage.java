package com.cloud.mvc.example.business.user.common;

import com.cloud.mvc.example.business.common.config.message.CodeAndMessage;

public enum  UserCodeAndMessage implements CodeAndMessage {

    VERIFY_CODE_ERROR(60001),

    LOGIN_INFO_NULL(60002),
    USER_NAME_NOT_FOUND(60003),
    BAD_CREDENTIALS_ERROR(60004),
    USER_ALREADY_LOCK(60005),
    USER_ALREADY_DISABLE(60006),
    USER_LOGIN_FAILED(60007),

    USER_ACCESS_DENY(60008),
    USER_CANNOT_ACCESS(60009)

    ;





















    private Integer code;


    UserCodeAndMessage(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
