package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.bean.BeanUtil;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class NotEmptyWhenConstraint implements ValidationConstraint<NotEmptyWhen> {

    String expression;

    private String fieldName;

    private String value;

    @Override
    public void configure(NotEmptyWhen annotation) {
        expression = annotation.value();
        fieldName = expression.split("=")[0].trim();
        value = expression.split("=")[1].trim();
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        Object obj = vcc.getTarget();
        Object objectInput = BeanUtil.forced.getProperty(obj, fieldName);
        String whenInput = Converter.get().toString(objectInput);
        if(!this.value.equals(whenInput)){
            return true;
        }
        if(value == null || value.equals("")){
            return false;
        }
        return true;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
