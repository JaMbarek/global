package com.cloud.mvc.example.business.common.config.web;

import com.cloud.mvc.example.business.common.config.message.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller抛出异常捕捉
 */
@ControllerAdvice({
        "com.cloud.mvc.example.bussiness.user.controller"
})
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = LoginException.class)
    public Resp assertErrorHandler(LoginException ex, HttpServletResponse response, HttpServletRequest request) {
        Resp resp = Resp.error(ex.getMessage());
        return resp;
    }

}
