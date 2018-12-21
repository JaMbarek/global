package com.cloud.mvc.example.business.common.config.message;

public enum CommonCodeAndMessage implements CodeAndMessage{

    OK(200),
    ERROR(500),

    VERIFY_CODE_ERROR(10001),

    LOGIN_INFO_NULL(10002),
    USER_NAME_NOT_FOUND(10003),
    BAD_CREDENTIALS_ERROR(10004),
    USER_ALREADY_LOCK(10005),
    USER_ALREADY_DISABLE(10006),
    USER_LOGIN_FAILED(10007),

    USER_ACCESS_DENY(10008),
    USER_CANNOT_ACCESS(10009)

    ;

    private Integer code;

    CommonCodeAndMessage(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
