package com.cloud.mvc.example.business.common.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients("com.cloud.mvc.example.common.service.**")
@Configuration
public class FeignScanConfiguration {
}
