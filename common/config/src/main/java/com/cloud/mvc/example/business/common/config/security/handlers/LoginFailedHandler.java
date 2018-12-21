package com.cloud.mvc.example.business.common.config.security.handlers;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.utils.ResponseUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.cloud.mvc.example.business.common.config.message.CommonCodeAndMessage.*;

@Component
@SuppressWarnings("all")
public class LoginFailedHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginFailedHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {



        if (exception instanceof UsernameNotFoundException){
            ResponseUtils.write(response, new Gson().toJson(Resp.error(USER_NAME_NOT_FOUND, request)));
            return;
        }

        if (exception instanceof BadCredentialsException){
            ResponseUtils.write(response, new Gson().toJson(Resp.error(BAD_CREDENTIALS_ERROR, request)));
            return;
        }
        //LockedException
        if (exception instanceof LockedException){
            ResponseUtils.write(response, new Gson().toJson(Resp.error(USER_ALREADY_LOCK, request)));
            return;
        }
        //DisabledException
        if (exception instanceof DisabledException){
            ResponseUtils.write(response, new Gson().toJson(Resp.error(USER_ALREADY_DISABLE, request)));
            return;
        }

        ResponseUtils.write(response, new Gson().toJson(Resp.error(USER_LOGIN_FAILED, request)));
        return;
    }
}
