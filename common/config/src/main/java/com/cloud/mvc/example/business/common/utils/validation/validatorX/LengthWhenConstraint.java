package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import com.google.common.collect.Range;
import jodd.bean.BeanUtil;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class LengthWhenConstraint implements ValidationConstraint<LengthWhen> {

    Integer min;
    Integer max;

    String expression;

    String fieldName;
    String value;

    Range<Integer> range = null;

    @Override
    public void configure(LengthWhen annotation) {
        min = annotation.min();
        max = annotation.max();
        expression = annotation.value();
        fieldName = annotation.value().split("=")[0];
        value = annotation.value().split("=")[1];
        range = Range.open(min, max);
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        String a = BeanUtil.forced.getProperty(vcc.getTarget(), fieldName);
        if(this.value.equals(a)){
            Integer inputLength = Converter.get().toString(value).length();
            return range.contains(inputLength);
        }

        return true;
    }
}
