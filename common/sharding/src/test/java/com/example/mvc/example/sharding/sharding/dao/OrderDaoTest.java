package com.example.mvc.example.sharding.sharding.dao;

import com.example.mvc.example.sharding.sharding.ShardingApplication;
import com.example.mvc.example.sharding.sharding.config.ShardingConfiguration;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderDaoTest {


    @Autowired
    OrderDao dao;

    @Test
    public void test(){
        System.out.println(new Gson().toJson(dao.findAll()));
    }

}