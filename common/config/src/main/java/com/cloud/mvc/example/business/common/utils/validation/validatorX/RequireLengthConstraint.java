package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class RequireLengthConstraint implements ValidationConstraint<RequireLength> {

    int length;

    @Override
    public void configure(RequireLength annotation) {
        length = annotation.value();
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        if(value == null) return true;
        return Converter.get().toString(value).length() == length;
    }
}
