package ${packageName};

<#list imports as i>
import ${i};
</#list>

/**
* Created by Administrator on ${.now}
*
*/
@RestController
@RequestMapping(SYSTEM_DICT_URL)
@Api(tags = "")
public interface ${className}Controller extends BaseController {

    @Autowired
    ${className}Service service;

    @ApiOperation("添加")
    @PostMapping
    public ResponseEntity save(@Validated ${className}Dto dictDto) throws Exception {
        int res = service.insert();
        return
    }


}