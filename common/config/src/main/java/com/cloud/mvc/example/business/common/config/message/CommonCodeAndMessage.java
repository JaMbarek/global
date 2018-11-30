package com.cloud.mvc.example.business.common.config.message;

public enum CommonCodeAndMessage implements CodeAndMessage{

    OK(200),
    ERROR(500),

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
