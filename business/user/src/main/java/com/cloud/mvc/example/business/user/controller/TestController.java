package com.cloud.mvc.example.business.user.controller;

import com.cloud.mvc.example.common.service.system.client.SystemDictServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    SystemDictServiceClient client;

    @GetMapping
    public String test(){
        System.out.println("ok");
        return "OK";
    }


    @GetMapping("findKey")
    public String get(){
        return client.findDictByKey("key1").getValue();
    }

}
