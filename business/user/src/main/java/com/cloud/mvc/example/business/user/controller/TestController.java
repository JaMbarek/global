package com.cloud.mvc.example.business.user.controller;

import com.cloud.mvc.example.business.domain.dto.user.RoleDto;
import com.cloud.mvc.example.business.domain.exceptions.IThrow;
import com.cloud.mvc.example.business.domain.resp.R;
import com.cloud.mvc.example.business.user.service.UserAccountService;
import com.cloud.mvc.example.common.service.system.client.RoleServiceClient;
import com.cloud.mvc.example.common.service.system.client.SystemDictServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    SystemDictServiceClient client;

    @Autowired
    RoleServiceClient roleServiceClient;


    @Autowired
    private UserAccountService service;

    @GetMapping
    public String test(){
        System.out.println("ok");
        return "OK";
    }


    @GetMapping("findKey")
    public Object get(){
        R<RoleDto> abc = roleServiceClient.findRoleByName("abc");
//        abc.getRuntimeException().ifPresent(IThrow::doThrow);
        return abc;
    }

    @GetMapping("/error")
    public Object error(){
        service.hystrix();
        return "OK";
    }


}
