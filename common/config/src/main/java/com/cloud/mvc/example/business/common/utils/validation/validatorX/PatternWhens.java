package com.cloud.mvc.example.business.common.utils.validation.validatorX;


import jodd.vtor.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(PatternWhensConstraint.class)
public @interface PatternWhens {
    PatternWhen[] value();



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
    String message() default "com.mchain.bourse.common.utils.validation.validatorX.PatternWhen";



}
