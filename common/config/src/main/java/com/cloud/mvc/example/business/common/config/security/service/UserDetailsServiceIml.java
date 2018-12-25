package com.cloud.mvc.example.business.common.config.security.service;

import com.cloud.mvc.example.business.common.config.security.beans.UserAccountDetail;
import com.cloud.mvc.example.business.domain.dto.RoleDto;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import com.cloud.mvc.example.business.domain.enums.Role;
import com.cloud.mvc.example.common.service.user.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceIml implements UserDetailsService  {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceIml.class);

    @Autowired
    IUserAccountService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("尝试获取用户信息，username={}", username);
        UserAccountDto dto = service.findUserAccountByPhone(username);

        Optional.ofNullable(dto).orElseThrow(() -> new UsernameNotFoundException("找不到用户信息"));

        UserAccountDetail detail = new UserAccountDetail();
        detail.setEmail(dto.getEmail());
        detail.setPhone(dto.getPhone());
        detail.setId(dto.getId());
        detail.setStatus(dto.getStatus());
        detail.setLock(dto.getLock());
        detail.setPassword(dto.getLoginPassword());


        List<Role> roleDto = service.collectGrantedAuthorities(dto.getId());
        List<GrantedAuthority> collect = roleDto.stream().map(t -> (GrantedAuthority) () -> t.getName()).collect(Collectors.toList());
        detail.setGrantedAuthorities(collect);

        return detail;
    }




}
