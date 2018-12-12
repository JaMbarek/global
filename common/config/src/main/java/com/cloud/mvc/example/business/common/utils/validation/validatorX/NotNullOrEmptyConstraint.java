package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class NotNullOrEmptyConstraint implements ValidationConstraint<NotNullOrEmpty> {


    @Override
    public void configure(NotNullOrEmpty annotation) {
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        return value != null && !value.equals("");
    }
}
