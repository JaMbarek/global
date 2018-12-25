package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import com.cloud.mvc.example.common.service.user.UserAccountServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/dict")
public class DictController {

    @Autowired
    UserAccountServiceClient client;


    @GetMapping
    public Resp<UserAccountDto> test(@RequestParam String phone){
        UserAccountDto accountDto = client.findUserAccountByPhone(phone);
        return Resp.success(accountDto);
    }




}
