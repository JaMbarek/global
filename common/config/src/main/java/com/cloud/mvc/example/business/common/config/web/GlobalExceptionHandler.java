package com.cloud.mvc.example.business.common.config.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * controller抛出异常捕捉
 */
@ControllerAdvice({
""
})
public class GlobalExceptionHandler {

    private   Logger LOGGER = LoggerFactory.getLogger(getClass());


}
