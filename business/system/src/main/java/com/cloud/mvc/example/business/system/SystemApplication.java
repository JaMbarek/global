package com.cloud.mvc.example.business.system;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.cloud.mvc.example.business.**")
@EnableDiscoveryClient
public class SystemApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SystemApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
