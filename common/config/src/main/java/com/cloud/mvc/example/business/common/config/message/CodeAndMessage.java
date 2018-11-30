package com.cloud.mvc.example.business.common.config.message;

public interface CodeAndMessage {

    default String getMessage(){
        String code = this.toString();
        return MessageUtils.getMessageByRequest(code);
    }

    Integer getCode();

}
