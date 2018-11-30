package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.common.config.message.PageInfo;
import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.supers.BaseController;
import com.cloud.mvc.example.business.system.dto.DictDto;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.vo.DictVo;
import com.cloud.mvc.example.utils.mapper.BeanMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.cloud.mvc.example.business.common.constants.UrlConstants.SystemUrlConstants.SYSTEM_DICT_URL;

@RestController
@RequestMapping(SYSTEM_DICT_URL)
@Api(tags = "系统常量接口")
public class DictController extends BaseController {

    @Autowired
    DictService service;

    @ApiOperation("添加")
    @PostMapping
    public Resp save(@Validated DictDto dictDto) throws Exception {
        int res = service.insert(BeanMapper.map(dictDto, Dict.class));
        return Resp.success(res);
    }

    @ApiOperation("修改")
    @PutMapping
    public Resp update(@Validated DictDto dictDto){
        int res = service.updateByPrimaryKey(BeanMapper.map(dictDto, Dict.class));
        return Resp.success(res);
    }

    @ApiOperation("查找一个")
    @GetMapping("{id}")
    public Resp findById(@PathVariable Long id){
        Dict dict = service.selectByPrimaryKey(id);
        return Resp.success(dict.map(DictVo.class));
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public Resp deleteById(@PathVariable Long id){
        return Resp.success(service.deleteByPrimaryKey(id));
    }

    @ApiOperation("分页查找列表")
    @GetMapping("/paging")
    public Resp paging(){
        PageInfo info = service.paging(null, null);
        return (Resp) info.map(Resp :: success);
    }





}
