package com.cloud.mvc.example.business.system;

import com.cloud.mvc.example.business.common.AbstractSpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class SystemApplication extends AbstractSpringApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SystemApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
