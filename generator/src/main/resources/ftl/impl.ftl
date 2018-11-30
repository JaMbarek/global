package ${packageName}.impl;

import org.springframework.stereotype.Service;
import com.cloud.mvc.example.business.common.supers.AbstractBaseService;
import ${packageName}.${className}Service;
<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on ${.now}
*
*/
@Service
public class ${className}ServiceImpl extends AbstractBaseService<${className}, ${className}Example> implements ${className}Service {


}