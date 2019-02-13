package com.cloud.mvc.example.business.message.web;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.message.service.MessageSendRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open/message")
public class MessageSendRecordController {


    @Autowired
    MessageSendRecordService sendRecordService;

    @GetMapping
    public Resp get(){
        return Resp.success(sendRecordService.all());
    }

}
