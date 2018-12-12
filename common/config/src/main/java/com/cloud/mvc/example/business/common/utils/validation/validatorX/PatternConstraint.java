package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.regex.Pattern;

public class PatternConstraint implements ValidationConstraint<PatternX> {

    Pattern pattern = null;

    @Override
    public void configure(PatternX annotation) {
        pattern = Pattern.compile(annotation.value());
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        return pattern.matcher(Converter.get().toString(value)).matches();
    }
}
