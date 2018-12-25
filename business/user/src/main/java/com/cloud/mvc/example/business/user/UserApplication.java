package com.cloud.mvc.example.business.user;

import com.cloud.mvc.example.business.common.config.feign.FeignScanConfiguration;
import com.cloud.mvc.example.business.common.config.mybatis.MybatisScanConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.cloud.mvc.example.business.**", "com.cloud.mvc.example.common.service.**"})
@EnableDiscoveryClient
@Import({
        FeignScanConfiguration.class,
        MybatisScanConfiguration.class,
})
public class UserApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
