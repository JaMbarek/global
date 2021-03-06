package com.cloud.mvc.example.basic.gateway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {

        new SpringApplicationBuilder(GatewayApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);

    }


}
