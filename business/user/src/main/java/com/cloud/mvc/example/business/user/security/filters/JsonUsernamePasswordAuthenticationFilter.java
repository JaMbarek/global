package com.cloud.mvc.example.business.user.security.filters;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.utils.ResponseUtils;
import com.cloud.mvc.example.business.domain.exceptions.user.LoginException;
import com.cloud.mvc.example.business.user.security.beans.UserLoginDto;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JsonUsernamePasswordAuthenticationFilter.class);

    @Autowired
    List<UserLoginFilter> list;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }


        String username = obtainUsername(request);
        String password = obtainPassword(request);
        UserLoginDto dto = null;

        if (!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)){
            dto = new UserLoginDto();
            dto.setUsername(username);
            dto.setPassword(password);
        }else{
            dto = readFromRequest(request);
        }

        for (UserLoginFilter t : list) {
            try {
                t.validate(dto, request);
            }catch (LoginException e){
                logger.warn("登录信息不合法：{}", e.getMessage());
                ResponseUtils.write(response, new Gson().toJson(Resp.error(e.getMessage())));
                return null;
            }
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                dto == null ? "" : dto.getUsername(), dto == null ? "" : dto.getPassword());

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    UserLoginDto readFromRequest(HttpServletRequest request){
        ServletInputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(new InputStreamReader(inputStream), UserLoginDto.class);
    }



}
