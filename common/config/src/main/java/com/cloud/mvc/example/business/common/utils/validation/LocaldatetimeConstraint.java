package com.cloud.mvc.example.business.common.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class LocaldatetimeConstraint implements ConstraintValidator<LocaldatetimeFuture, LocalDateTime> {



    @Override
    public void initialize(LocaldatetimeFuture constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if(value == null) return true;
        return value.isAfter(LocalDateTime.now());
    }
}
