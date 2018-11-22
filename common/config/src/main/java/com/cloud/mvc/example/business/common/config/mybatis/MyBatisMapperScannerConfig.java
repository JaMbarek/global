package com.cloud.mvc.example.business.common.config.mybatis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 扫描mybatis的接口
 *
 */
@Configuration
public class MyBatisMapperScannerConfig  {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DataSource dataSource;



}
