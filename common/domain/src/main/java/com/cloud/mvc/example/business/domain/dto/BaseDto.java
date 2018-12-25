package com.cloud.mvc.example.business.domain.dto;




import com.cloud.mvc.example.utils.mapper.BeanMapper;

import java.util.Optional;

public abstract class BaseDto {

    public <T> Optional<T> toOptional() {
        return (Optional<T>) Optional.ofNullable(this);
    }

    public <T> T map(Class<T> clazz) {
        return BeanMapper.map(this, clazz);
    }

}
