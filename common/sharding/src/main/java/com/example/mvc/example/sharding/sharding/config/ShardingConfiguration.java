package com.example.mvc.example.sharding.sharding.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(ShardingPropertiesConfiguration.class)
public class ShardingConfiguration {


    public static void main(String[] args) throws Exception {


    }



    @Resource
    DataSource master;





}
