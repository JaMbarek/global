package com.cloud.mvc.example.business.user.controller;

import com.cloud.mvc.example.business.common.config.message.Resp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/test")
    public Resp test(){
        return Resp.success("success");
    }


}
