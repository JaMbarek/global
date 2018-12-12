package com.cloud.mvc.example.business.common.utils.validation.validatorX;

import jodd.bean.BeanUtil;
import jodd.typeconverter.Converter;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

import java.util.regex.Pattern;


public class PatternWhensConstraint implements ValidationConstraint<PatternWhens> {

    private String expression;

    PatternWhen[] pws;

    @Override
    public void configure(PatternWhens annotation) {
        pws = annotation.value();
    }

    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
        if(value == null) return true;

        for (PatternWhen pw : pws){

            String regex = pw.regex();
            Pattern p = Pattern.compile(regex);
            String key = pw.value().split("=")[0];
            String string = pw.value().split("=")[1];
            Object obj = BeanUtil.declared.getProperty(vcc.getTarget(), key);
            String input = Converter.get().toString(obj);
            if(string.equals(input)){
                if(!p.matcher(Converter.get().toString(value)).matches()){
                    expression = pw.value();
                    return false;
                }
                continue;
            }
        }
        return true;
    }
}
