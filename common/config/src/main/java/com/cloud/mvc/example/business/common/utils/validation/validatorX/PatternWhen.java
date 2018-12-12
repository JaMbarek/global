package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.vtor.Constraint;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(PatternWhenConstraint.class)
@Repeatable(PatternWhens.class)
public @interface PatternWhen {

    String value();

    String regex();


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
    String message() default "com.mchain.bourse.common.utils.validation.validatorX.PatternWhen";





}
