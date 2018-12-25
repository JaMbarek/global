package com.cloud.mvc.example.common.service.common;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ConditionOnNotAppName implements Condition {

//    @Value("${spring.application.name}")//无法注入
//    String name;


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String name = context.getEnvironment().resolvePlaceholders("${spring.application.name}");
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionOnNotApp.class.getName());
        String serviceName = (String) annotationAttributes.get("value");
        return !serviceName.equalsIgnoreCase(name);
    }
}
