package com.cloud.mvc.example.business.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
* Created by Administrator on 2018-11-26
*
*/
@Data
@ApiModel
public class DictDto {

    interface Create{}
    interface Update{}

    @ApiModelProperty("主键")
    @NotNull
    private Long id;

    @ApiModelProperty("组名称")
    private String group;

    @ApiModelProperty("key值")
    private String key;

    @ApiModelProperty("vallue值")
    private String value;

}