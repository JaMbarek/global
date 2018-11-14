package com.cloud.mvc.example.basic.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminApplicationTests {


    @Value("${admin.port.test}")
    private Integer port;


    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {
        String property = environment.getProperty("admin.port.test");
        System.out.println(property);


        System.out.println(port);
    }

}
