package com.cloud.mvc.example.business.user.security.service;

import com.cloud.mvc.example.business.user.security.beans.Role;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDetailsServiceIml implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceIml.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("尝试获取用户信息，username={}", username);
        return new UserInfoDetail(1L, username, "123456", LocalDateTime.now(), LocalDateTime.now(), Lists.newArrayList(new Role("admin")));
    }




}
