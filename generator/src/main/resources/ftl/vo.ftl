package ${packageName};

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import com.cloud.mvc.example.business.common.supers.BaseVo;
<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on ${.now}
*
*/
@Data
@ApiModel
public class ${className} extends BaseVo{

<#list columns as column>
    @ApiModelProperty("${column.remarks}")
    private ${column.fullyQualifiedJavaType.shortName} ${column.javaProperty};

</#list>
}