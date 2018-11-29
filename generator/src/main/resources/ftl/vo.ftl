package ${packageName};

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on 2018-11-26
*
*/
@Data
@ApiModel
public class ${className} {

<#list columns as column>
    @ApiModelProperty("${column.remarks}")
    private ${column.fullyQualifiedJavaType.shortName} ${column.javaProperty};

</#list>
}