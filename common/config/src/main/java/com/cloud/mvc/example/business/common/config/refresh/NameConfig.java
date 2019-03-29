package com.cloud.mvc.example.business.common.config.refresh;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameConfig {

    @Bean
    @RefreshScope
    RefreshBean bean(){
        return new RefreshBean();
    }





}
