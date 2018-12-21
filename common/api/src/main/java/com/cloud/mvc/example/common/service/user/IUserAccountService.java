package com.cloud.mvc.example.common.service.user;

import com.cloud.mvc.example.business.domain.dto.RoleDto;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@RequestMapping("/account")
public interface IUserAccountService {

    @GetMapping("/findUserAccountByPhone")
    UserAccountDto findUserAccountByPhone(@RequestParam("phone") String phone);

    @GetMapping("/findUserAccountByEmail")
    UserAccountDto findUserAccountByEmail(@RequestParam("email") String email);

    @GetMapping("/collectGrantedAuthorities/{id}")
    List<RoleDto> collectGrantedAuthorities(@PathVariable("id") Long id);

}
