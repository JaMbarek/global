package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.regex.Pattern;

public class PatternXConstraint implements ValidationConstraint<PatternX> {

    String regex = null;
    Pattern pattern = null;

    @Override
    public void configure(PatternX annotation) {
        regex = annotation.value();
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        if(value == null) return true;
        return pattern.matcher(Converter.get().toString(value)).matches();
    }
}
