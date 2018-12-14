package com.cloud.mvc.example.business.common.config.message;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public final class Resp<T> {

    T data;
    Integer code;
    String message;

    public static Resp success(Object data){
        Resp resp = new Resp();
        resp.code = CommonCodeAndMessage.OK.getCode();
        resp.message = CommonCodeAndMessage.OK.getMessage();
        resp.data = data;
        return resp;
    }


    public static Resp success(Object data, HttpServletRequest request){
        Resp resp = new Resp();
        resp.code = CommonCodeAndMessage.OK.getCode();
        resp.message = CommonCodeAndMessage.OK.getMessage(request);
        resp.data = data;
        return resp;
    }

    public static Resp success(){
        Resp resp = new Resp();
        resp.code = CommonCodeAndMessage.OK.getCode();
        resp.message = CommonCodeAndMessage.OK.getMessage();
        resp.data = null;
        return resp;
    }



    public static Resp error(CodeAndMessage message){
        Resp resp = new Resp();
        resp.code = message.getCode();
        resp.message = message.getMessage();
        return resp;
    }

    public static Resp error(CodeAndMessage message, HttpServletRequest request){
        Resp resp = new Resp();
        resp.code = message.getCode();
        resp.message = message.getMessage(request);
        return resp;
    }

    public static Resp error(String message){
        Resp resp = new Resp();
        resp.code = 500;
        resp.message = message;
        return resp;
    }

    public static Resp paging(PageInfo info){
        Resp resp = new Resp();
        resp.code = CommonCodeAndMessage.OK.getCode();
        resp.message = CommonCodeAndMessage.OK.getMessage();
        resp.data = info;
        return resp;
    }


}
