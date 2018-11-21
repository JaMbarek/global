package com.cloud.mvc.example.general.supers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Integer createUserId;
    private Integer modifyUserId;
    private Integer status;
    private Integer version;
}
