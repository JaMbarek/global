package com.cloud.mvc.example.business.common.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Constraint(validatedBy = NotEmptyListConstraint.class)
public @interface NotEmptyList {
    String message() default "{com.mchain.bourse.common.utils.validation.NotEmptyList.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
