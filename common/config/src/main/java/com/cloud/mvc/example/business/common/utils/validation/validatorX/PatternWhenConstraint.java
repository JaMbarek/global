package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.bean.BeanUtil;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.regex.Pattern;

public class PatternWhenConstraint implements ValidationConstraint<PatternWhen> {

    private String expression;
    private Pattern pattern = null;

    private String fieldName;
    private String value;


    @Override
    public void configure(PatternWhen annotation) {
        expression = annotation.value();
        pattern = Pattern.compile(annotation.regex());
        fieldName = expression.split("=")[0];
        value = expression.split("=")[1];
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        if(value == null) return true;
        Object obj = BeanUtil.declared.getProperty(vcc.getTarget(), fieldName);
        String a = Converter.get().toString(obj);
        if(this.value.equals(a)){
            return pattern.matcher(Converter.get().toString(value)).matches();
        }

        return true;
    }
}
