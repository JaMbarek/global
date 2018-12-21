package com.cloud.mvc.example.business.common.config.refresh;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class NameConfig {

    @Bean
    @RefreshScope
    RefreshBean bean(){
        return new RefreshBean();
    }





}
