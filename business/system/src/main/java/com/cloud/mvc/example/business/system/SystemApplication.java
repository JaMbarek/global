package com.cloud.mvc.example.business.system;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.cloud.mvc.example.business.**")
@EnableDiscoveryClient
@MapperScan("com.cloud.mvc.example.business.system.dao")
@EnableApolloConfig
@EnableScheduling
@EnableFeignClients("com.cloud.mvc.example.common.service.**")
public class SystemApplication {

    public static void main(String[] args) {
        System.setProperty("env", "dev");
        new SpringApplicationBuilder(SystemApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
