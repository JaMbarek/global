package com.cloud.mvc.example.business.common.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.cloud.mvc.example.business.*.dao")
@Configuration
public class MybatisScanConfiguration {
}
