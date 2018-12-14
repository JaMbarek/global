package com.cloud.mvc.example.business.common.config.message;

import javax.servlet.http.HttpServletRequest;

public interface CodeAndMessage {

    default String getMessage(){
        String code = this.toString();
        return MessageUtils.getMessageByRequest(code).trim();
    }

    default String getMessage(HttpServletRequest request){
        String code = this.toString();
        return MessageUtils.getMessageByRequest(code, request).trim();
    }


    Integer getCode();

}
