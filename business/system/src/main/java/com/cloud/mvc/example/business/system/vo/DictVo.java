package com.cloud.mvc.example.business.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import com.cloud.mvc.example.business.common.supers.BaseVo;
import com.cloud.mvc.example.business.common.supers.BaseEntity;
import java.time.LocalDateTime;

/**
* Created by Administrator on 2018-12-13 17:59:45
*
*/
@Data
@ApiModel
public class DictVo extends BaseVo{

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("组名称")
    private String group;

    @ApiModelProperty("key值")
    private String key;

    @ApiModelProperty("vallue值")
    private String value;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    private LocalDateTime modifyDate;

    @ApiModelProperty("状态1有效0无效")
    private Integer status;

}