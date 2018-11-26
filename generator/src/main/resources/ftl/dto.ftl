package ${packageName};

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
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

    interface Create{}
    interface Update{}

<#list columns as column>
    @ApiModelProperty("${column.remarks}")
    <#if !column.nullable>
    @NotNull
    </#if>
    private ${column.fullyQualifiedJavaType.shortName} ${column.javaProperty};

</#list>
}