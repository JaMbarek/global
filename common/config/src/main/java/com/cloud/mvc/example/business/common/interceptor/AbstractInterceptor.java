package com.cloud.mvc.example.business.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public abstract class AbstractInterceptor extends HandlerInterceptorAdapter {


    abstract String path();


}
