package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import com.mchain.bourse.common.aspect.ValidateMethodAspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see ValidateMethodAspect
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ValidateMethod {

    String value() default "";

}
