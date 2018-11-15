package com.cloud.mvc.example.basic.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayApplicationTests {

    @Value("${service.name}")
    private String serviceName;

    @Value("${outer.property.name}")
    private String properName;


    @Test
    public void test(){
        System.out.println(serviceName);//application.peroperties和application.yml文件同时存在时properties文件的属性会覆盖yml文件的属性
    }

    @Test
    public void testProperName(){
        System.out.println(properName);//properties文件和yml文件同时在外部时，yml文件可以读取properties文件的属性,properties文件也是可以读取yml文件的内容
    }



}
