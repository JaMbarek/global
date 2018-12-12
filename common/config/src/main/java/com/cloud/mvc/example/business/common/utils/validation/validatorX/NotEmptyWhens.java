package com.cloud.mvc.example.business.common.utils.validation.validatorX;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在一定的條件下验证是否为null和空字符串
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotEmptyWhens {
    NotEmptyWhen[] value();
}
