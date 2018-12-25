package com.cloud.mvc.example.business.common.supers;


import com.cloud.mvc.example.utils.mapper.BeanMapper;

import java.util.Optional;

@SuppressWarnings("all")
public abstract class BaseVo {

    public <T> Optional<T> toOptional() {
        return (Optional<T>) Optional.ofNullable(this);
    }

    public <T> T map(Class<T> clazz) {
        return BeanMapper.map(this, clazz);
    }

}
