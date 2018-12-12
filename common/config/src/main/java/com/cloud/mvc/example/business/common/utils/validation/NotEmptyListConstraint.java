package com.cloud.mvc.example.business.common.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListConstraint implements ConstraintValidator<NotEmptyList, List> {




    @Override
    public void initialize(NotEmptyList constraintAnnotation) {

    }

    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        return value != null && value.size() > 0;
    }
}
