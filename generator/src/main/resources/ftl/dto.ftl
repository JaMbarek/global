package ${packageName};

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import com.cloud.mvc.example.business.common.supers.BaseDto;
<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on ${.now}
*
*/
@Data
@ApiModel
public class ${className} extends BaseDto{

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