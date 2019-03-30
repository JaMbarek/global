package com.cloud.mvc.example.business.common.config.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataCondition implements Condition {

    private static final Logger LOG = LoggerFactory.getLogger(DataCondition.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String name = context.getEnvironment().getProperty("spring.application.name");
        LOG.info("当前应用名称：{}", name);
        return !name.equals("message");
    }
}
