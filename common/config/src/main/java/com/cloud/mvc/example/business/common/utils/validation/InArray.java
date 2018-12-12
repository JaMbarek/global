package com.cloud.mvc.example.business.common.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * null -> true
 *
 * int、string、long
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Constraint(validatedBy = InArrayConstraint.class)
public @interface InArray {

    String[] value();

    String message() default "{com.mchain.bourse.common.utils.validation.InArray.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
