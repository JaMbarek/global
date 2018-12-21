package com.cloud.mvc.example.business.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @GetMapping
    public String test(){
        System.out.println("ok");
        return "OK";
    }


}
