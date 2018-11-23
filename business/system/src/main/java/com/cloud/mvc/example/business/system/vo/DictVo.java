package com.cloud.mvc.example.business.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DictVo {

    @ApiModelProperty("key")
    private String key;

    @ApiModelProperty("value")
    private String value;
}
