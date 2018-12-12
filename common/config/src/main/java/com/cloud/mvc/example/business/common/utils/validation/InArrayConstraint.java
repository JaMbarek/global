package com.cloud.mvc.example.business.common.utils.validation;

import com.google.common.collect.Lists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class InArrayConstraint  implements ConstraintValidator<InArray, Object> {

    private List<String> list = Lists.newArrayList();

    @Override
    public void initialize(InArray constraintAnnotation) {
        list = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) return true;

        if(value instanceof Integer){
            return list.contains(value.toString());
        }
        if(value instanceof Long){
            return list.contains(value.toString());
        }
        if(value instanceof String){
            return list.contains(value.toString());
        }
        return false;
    }
}
