package com.cloud.mvc.example.common.service.user;

import com.cloud.mvc.example.business.domain.constants.UrlConstants;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import com.cloud.mvc.example.business.domain.enums.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserAccountService {

    String path = UrlConstants.UserUrlConstants.USER_ACCOUNT_URL;


    @GetMapping("/findUserAccountByPhone")
    UserAccountDto findUserAccountByPhone(@RequestParam("phone") String phone);

    @GetMapping("/findUserAccountByEmail")
    UserAccountDto findUserAccountByEmail(@RequestParam("email") String email);

    @GetMapping("/collectGrantedAuthorities/{id}")
    List<Role> collectGrantedAuthorities(@PathVariable("id") Long id);

}
