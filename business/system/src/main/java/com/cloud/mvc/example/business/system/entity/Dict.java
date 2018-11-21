package com.cloud.mvc.example.business.system.entity;

import com.cloud.mvc.example.general.supers.BaseEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/11/21
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dict extends BaseEntity {
    private Long id;

    private String group;

    private String key;

    private String value;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer status;
}