package com.cloud.mvc.example.business.domain.dto.system;

import com.cloud.mvc.example.business.domain.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;

/**
* Created by Administrator on 2018-12-13 17:59:45
*
*/
@Data
@ApiModel
public class DictDto extends BaseDto {

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

    @ApiModelProperty("状态1有效0无效")
    private Integer status;


}