package com.cloud.mvc.example.business.user;

import com.cloud.mvc.example.business.common.AbstractSpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class UserApplication extends AbstractSpringApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
