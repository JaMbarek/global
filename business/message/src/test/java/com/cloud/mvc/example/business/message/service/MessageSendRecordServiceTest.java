package com.cloud.mvc.example.business.message.service;

import com.cloud.mvc.example.business.message.MessageApplication;
import com.cloud.mvc.example.business.message.dao.MessageSendRecordDao;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageSendRecordServiceTest {

    @Autowired
    MessageSendRecordDao dao;


    @Test
    public void testTest1() {
        System.out.println(new Gson().toJson(dao.findAll()));
    }
}