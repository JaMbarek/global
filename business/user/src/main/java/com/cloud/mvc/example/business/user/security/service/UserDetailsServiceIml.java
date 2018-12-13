package com.cloud.mvc.example.business.user.security.service;

import com.cloud.mvc.example.business.user.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceIml implements UserDetailsService  {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceIml.class);

    @Autowired
    UserAccountService service;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("尝试获取用户信息，username={}", username);
        UserDetails details = service.getUserInfoDetailByUserName(username);
        Optional.ofNullable(details).orElseThrow(() -> new UsernameNotFoundException("找不到用户信息"));
        return details;
    }




}
