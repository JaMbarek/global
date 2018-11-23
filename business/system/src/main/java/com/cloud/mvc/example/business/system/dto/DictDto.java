package com.cloud.mvc.example.business.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel
public class DictDto {

    @NotEmpty
    @ApiModelProperty("唯一key")
    private String key;

    @NotEmpty
    @ApiModelProperty("值")
    private String value;



}
