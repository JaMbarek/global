package com.cloud.mvc.example.business.common;

import com.cloud.mvc.example.business.common.config.feign.FeignScanConfiguration;
import com.cloud.mvc.example.business.common.config.mybatis.TransactionConfiguration;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.cloud.mvc.example.business.**", "com.cloud.mvc.example.common.service.**"})
@EnableDiscoveryClient
@Import({
        FeignScanConfiguration.class,
        TransactionConfiguration.class,
})
//@EnableApolloConfig
public abstract class AbstractSpringApplication {
}
