package com.cloud.mvc.example.business.common.config.feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Autowired
    SecurityProperties properties;


    @Bean
    public BasicAuthRequestInterceptor feignBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(properties.getUser().getName(), properties.getUser().getPassword());
    }




}
