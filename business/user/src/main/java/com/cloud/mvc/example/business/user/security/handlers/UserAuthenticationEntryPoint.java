package com.cloud.mvc.example.business.user.security.handlers;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.utils.ResponseUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.cloud.mvc.example.business.user.common.UserCodeAndMessage.USER_CANNOT_ACCESS;

/**
 * 对于未登录权限控制
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.warn("用户无权限访问");
        ResponseUtils.write(response, new Gson().toJson(Resp.error(USER_CANNOT_ACCESS, request)));
    }
}
