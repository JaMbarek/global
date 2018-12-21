package com.cloud.mvc.example.business.user.common;

import com.cloud.mvc.example.business.common.config.message.CodeAndMessage;

public enum  UserCodeAndMessage implements CodeAndMessage {



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
