package ${packageName};

import com.cloud.mvc.example.business.common.supers.BaseService;
<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on ${.now}
*
*/
public interface ${className}Service extends BaseService<${className}, ${className}Example> {

}