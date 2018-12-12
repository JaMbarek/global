package com.cloud.mvc.example.business.common.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

@Configuration
public class FilterConfig {


    @Bean
    public WebFilter webFilter(){
        return new AddHeaderWebFilter();
    }


}
