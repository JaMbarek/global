package com.cloud.mvc.example.business.common.supers;

import com.cloud.mvc.example.utils.mapper.BeanMapper;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@SuppressWarnings("all")
public class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long createUserId;
    private Long modifyUserId;
    private String createUserName;
    private String modifyUserName;
    private Integer status;
    private Integer version;



    public <T> Optional<T> toOptional() {
        return (Optional<T>) Optional.ofNullable(this);
    }

    public <T> T map(Class<T> clazz) {
        return BeanMapper.map(this, clazz);
    }

}
