package com.cloud.mvc.example.business.common.utils.validation;

import com.google.common.collect.Lists;
import com.mchain.bourse.common.excetions.base.LanguageException;
import com.mchain.bourse.common.i18n.entity.I18nContentDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static com.mchain.bourse.common.language.LanguageCodeConstant.*;
import static com.mchain.bourse.common.resp.code.RespCodeAndMessageEnum.LANGUAGE_TYPE_NOT_EXISTS;
import static com.mchain.bourse.common.resp.code.RespCodeAndMessageEnum.LANGUAGE_TYPE_REPEAT;

public class I18nConstraint implements ConstraintValidator<I18nValid, List<I18nContentDto>> {

    private List list = null;

    @Override
    public void initialize(I18nValid constraintAnnotation) {
        list = Lists.newArrayList(ENGLISH, SIMPLIFIED_CHINESE, TRADITIONAL_CHINESE);
    }

    @Override
    public boolean isValid(List<I18nContentDto> value, ConstraintValidatorContext context) {
        if(list == null || list.size() < 1) return true;
        if(value == null || value.size() < 1) return true;
        //code不允许重复
        boolean distinct = value.stream().map(a -> a.getLanguageCode())
                .distinct()
                .count() == value.size();

        if(!distinct){
            LanguageException.create(LANGUAGE_TYPE_REPEAT).doThrow();
        }

        boolean ok =  value.stream()
                .filter(a -> !list.contains(a.getLanguageCode()))
                .findAny()
                .isPresent();

        if(ok){
            LanguageException.create(LANGUAGE_TYPE_NOT_EXISTS).doThrow();
        }

        return true;
    }
}
