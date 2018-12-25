package com.cloud.mvc.example.common.service.common;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(ConditionOnNotAppName.class)
public @interface ConditionOnNotApp {


    /**
     * #{spring.application.name} != <code>value()</>
     * 当服务名称不等于value（）时注入feignclient
     * 目的是远程服务和本地服务进行整合
     * @return
     */
    String value() default "";



}
