package com.cloud.mvc.example.business.common.supers;


import com.cloud.mvc.example.business.common.utils.BeanMapper;

import java.util.Optional;

public abstract class BaseDto {

    public <T> Optional<T> toOptional() {
        return (Optional<T>) Optional.ofNullable(this);
    }

    public <T> T map(Class<T> clazz) {
        return BeanMapper.map(this, clazz);
    }

}
