package com.cloud.mvc.example.business.common.config.web;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.domain.exceptions.InternalServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller抛出异常捕捉
 */
@RestControllerAdvice({
        "com.cloud.mvc.example.business.user.controller"
})
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = LoginException.class)
    public Resp assertErrorHandler(LoginException ex, HttpServletResponse response, HttpServletRequest request) {
        Resp resp = Resp.error(ex.getMessage());
        return resp;
    }


    @ExceptionHandler(value = InternalServerException.class)
    public Resp assertErrorHandler(InternalServerException ex, HttpServletResponse response, HttpServletRequest request) {
        Resp resp = Resp.error(ex.getDescription());
        return resp;
    }



    @ExceptionHandler(value = Exception.class)
    public Resp assertErrorHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) {
        LOGGER.error("发生异常：", ex    );
        Resp resp = Resp.error(ex.getMessage());
        return resp;
    }

}
