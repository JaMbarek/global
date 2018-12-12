package com.cloud.mvc.example.business.common.utils.validation.validatorX;


import jodd.vtor.Constraint;

import java.lang.annotation.*;

/**
 * 在一定的條件下验证是否为null和空字符串
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(NotEmptyWhenConstraint.class)
@Repeatable(NotEmptyWhens.class)
public @interface NotEmptyWhen {

    String value();



    // ---------------------------------------------------------------- common

    /**
     * Profiles.
     */
    String[] profiles() default {};

    /**
     * Severity.
     */
    int severity() default 0;

    /**
     * Message.
     */
    String message() default "com.mchain.bourse.common.utils.validation.validatorX.NotEmptyWhen";


}
