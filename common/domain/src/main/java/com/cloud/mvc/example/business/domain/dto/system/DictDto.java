package com.cloud.mvc.example.business.domain.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class DictDto {

    @ApiModelProperty("键值，唯一校验")
    private String key;

    @ApiModelProperty("值")
    private String value;

}
