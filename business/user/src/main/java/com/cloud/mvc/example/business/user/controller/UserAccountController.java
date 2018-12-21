package com.cloud.mvc.example.business.user.controller;

import com.cloud.mvc.example.business.domain.dto.RoleDto;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import com.cloud.mvc.example.business.user.service.UserAccountService;
import com.cloud.mvc.example.common.service.user.IUserAccountService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class UserAccountController implements IUserAccountService {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);


    @Autowired
    UserAccountService service;

    @Override
    public UserAccountDto findUserAccountByPhone(String phone) {
        logger.debug("user服务根据手机号码查询用户账户, phone={}", phone);
        return service.findUserAccountByPhone(phone);
    }

    @Override
    public UserAccountDto findUserAccountByEmail(String email) {
        logger.debug("user服务根据邮箱查询用户账户, email={}", email);
        return null;
    }

    @Override
    public List<RoleDto> collectGrantedAuthorities(Long id) {
        logger.debug("user服务查询用户的权限信息。id={}", id);
        return Lists.newArrayList();
    }
}
