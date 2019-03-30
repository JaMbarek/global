package com.example.mvc.example.sharding.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "sharding.datasource")
@Data
public class ShardingPropertiesConfiguration {


    Map<String, DruidDataSource> cutDatasource;





}
