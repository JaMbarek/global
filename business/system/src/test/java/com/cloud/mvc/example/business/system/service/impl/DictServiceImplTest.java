package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.system.SystemApplication;
import com.cloud.mvc.example.business.system.service.DictService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DictServiceImplTest {


    @Autowired
    DictService service;
    @Test
    public void getBeanByIds() {
        service.getBeanByIds(Lists.newArrayList(11L, 2L, 3L))
                .subscribe(t -> System.out.println(t));
    }
}