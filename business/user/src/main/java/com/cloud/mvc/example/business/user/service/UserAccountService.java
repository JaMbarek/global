package com.cloud.mvc.example.business.user.service;

import com.cloud.mvc.example.business.user.dao.UserAccountMapper;
import com.cloud.mvc.example.business.user.entity.UserAccount;
import com.cloud.mvc.example.business.user.entity.UserAccountExample;
import com.cloud.mvc.example.business.user.security.service.UserInfoDetail;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class UserAccountService {

    @Autowired
    UserAccountMapper mapper;


    private Function<UserAccount, UserInfoDetail> transater = t -> {
        UserInfoDetail detail = new UserInfoDetail();
        detail.setPhone(t.getPhone());
        detail.setEmail(t.getEmail());
        detail.setPassword(t.getLoginPassword());
        detail.setId(t.getId());
        detail.setStatus(t.getStatus());
        detail.setLock(t.getLock());
        return detail;
    };

    public UserInfoDetail getUserInfoDetailByUserName(String username){
        UserAccountExample example = new UserAccountExample();
        example.createCriteria()
                .andPhoneEqualTo(username);
        List<UserAccount> userAccounts = mapper.selectByExample(example);
        return userAccounts.stream()
                .findFirst()
                .map(transater)
                .orElse(null);

    }

    public List<GrantedAuthority> collectGrantedAuthorities(Long userAccountId){
        return Lists.newArrayList();
    }



}
