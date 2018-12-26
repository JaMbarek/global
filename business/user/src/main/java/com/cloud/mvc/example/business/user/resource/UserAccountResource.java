package com.cloud.mvc.example.business.user.resource;

import com.cloud.mvc.example.business.domain.dto.user.UserAccountDto;
import com.cloud.mvc.example.business.domain.enums.Role;
import com.cloud.mvc.example.business.domain.resp.R;
import com.cloud.mvc.example.business.user.service.UserAccountService;
import com.cloud.mvc.example.common.service.user.IUserAccountService;
import com.google.common.collect.Lists;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserAccountResource.path)
@SuppressWarnings("all")
public class UserAccountResource implements IUserAccountService {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountResource.class);

    @Autowired
    UserAccountService service;

    @Override
    public R<UserAccountDto> findUserAccountByPhone(String phone) {
        logger.debug("user服务根据手机号码查询用户账户, phone={}", phone);
        return R.from(Try.of(() -> service.findUserAccountByPhone(phone)));
    }

    @Override
    public R<UserAccountDto> findUserAccountByEmail(String email) {
        logger.debug("user服务根据邮箱查询用户账户, email={}", email);
        return R.from(Try.of(() -> service.findUserAccountByEmail(email)));
    }

    @Override
    public R<List<Role>> collectGrantedAuthorities(Long id) {
        logger.debug("user服务查询用户的权限信息。id={}", id);
        return R.success(Lists.newArrayList(Role.USER));
    }
}
