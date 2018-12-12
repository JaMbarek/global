package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import com.google.common.collect.FluentIterable;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.Arrays;

public class InArrayXConstraint implements ValidationConstraint<InArrayX> {

    String[] ss = null;

    String strings = "";

    @Override
    public void configure(InArrayX annotation) {
        ss = annotation.value();
        strings = Arrays.toString(annotation.value());
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        if(value == null) return true;
        String v = Converter.get().toString(value);
        return FluentIterable.from(ss).contains(v);
    }


    public String[] getSs() {
        return ss;
    }

    public void setSs(String[] ss) {
        this.ss = ss;
    }

    public String getStrings() {
        return strings;
    }

    public void setStrings(String strings) {
        this.strings = strings;
    }
}
