package com.cloud.mvc.example.business.common.utils.validation.validatorX;


import jodd.bean.BeanUtil;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class NotEqualToFieldConstraint implements ValidationConstraint<NotEqualToField> {

    String fieldName;


    @Override
    public void configure(NotEqualToField annotation) {
        fieldName = annotation.value();
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {

        if(value == null) return true;
        String equalValue = BeanUtil.declared.getProperty(vcc.getTarget(), fieldName);
        String stringValue = Converter.get().toString(value);
        return !stringValue.equals(equalValue);
    }
}
