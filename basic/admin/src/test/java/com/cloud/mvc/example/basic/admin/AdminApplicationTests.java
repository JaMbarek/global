package com.cloud.mvc.example.basic.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class AdminApplicationTests {


    private String serviceName;

    @Value("${name}")
    private String name;

    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {

        System.out.println(serviceName);
    }

    @Test
    public void name(){
        System.out.println(name);
    }

}
