package com.cloud.mvc.example.business.user.security.handlers;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.utils.BeanMapper;
import com.cloud.mvc.example.business.common.utils.ResponseUtils;
import com.cloud.mvc.example.business.user.security.service.UserInfoDetail;
import com.cloud.mvc.example.business.user.utils.JwtTokenUtil;
import com.cloud.mvc.example.business.user.vo.UserLoginVo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.debug("用户登录成功");
        UserInfoDetail detail = (UserInfoDetail) authentication.getPrincipal();

        UserLoginVo vo = BeanMapper.map(detail, UserLoginVo.class);

        vo.setToken(jwtTokenUtil.generateToken(vo.getPhone()));
        ResponseUtils.write(response, new Gson().toJson(Resp.success(vo, request)));
    }
}
