package com.cloud.mvc.example.business.domain.entity.user;

import com.cloud.mvc.example.business.domain.entity.BaseEntity;
import lombok.Data;

@Data
public class UserInfo extends BaseEntity {
    private Long id;
    private String loginName;
    private String realName;
    private String lastLoginIp;
}
