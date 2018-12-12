package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.common.config.message.PageInfo;
import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.request.PageHolder;
import com.cloud.mvc.example.business.common.supers.BaseController;
import com.cloud.mvc.example.business.system.dto.DictDto;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.vo.DictVo;
import com.cloud.mvc.example.utils.mapper.BeanMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

import static com.cloud.mvc.example.business.common.constants.UrlConstants.SystemUrlConstants.SYSTEM_DICT_URL;

@RestController
@RequestMapping(SYSTEM_DICT_URL)
@Api(tags = "系统常量接口")
public class DictController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DictController.class);

    @Autowired
    DictService service;

    @Autowired
    PageHolder holder;

    @ApiOperation("添加")
    @PostMapping
    public Resp save(@Validated DictDto dictDto) throws Exception {
        int res = service.insert(BeanMapper.map(dictDto, Dict.class));
        return Resp.success("还可以");
    }

    @ApiOperation("修改")
    @PutMapping
    public Resp update(@Validated DictDto dictDto){
        int res = service.updateByPrimaryKey(BeanMapper.map(dictDto, Dict.class));
        return Resp.success(res);
    }

    @ApiOperation("查找一个")
    @GetMapping("{id}")
    public Resp findById(@PathVariable Long id, HttpServletRequest request){
//        Dict dict = service.selectByPrimaryKey(id);
        Resp resp = Resp.success("哈可以");
        logger.debug("resp:{}",  resp.toString());
        logger.debug("page:", holder.toString());
        return resp;
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public Resp deleteById(@PathVariable Long id){
        return Resp.success(service.deleteByPrimaryKey(id));
    }

    @ApiOperation("分页查找列表")
    @GetMapping("/paging")
    public Resp paging(@RequestParam(required = false) String key){
        PageInfo info = service.selectByPaging(key);
        return (Resp) info.map(Resp :: success);
    }

    @PostMapping("/test")
    public Resp test(@Header("X-Request-id") String id, @Header("headler") String rId, HttpServletRequest request){


        System.out.println(request.getHeader("NAME"));
        System.out.println(request.getHeader("headler"));

        return Resp.success(id + "-" + rId);
    }

    @PostMapping("/error")
    public Resp error(){
        System.out.println("-----------------------ex");
        throw new RuntimeException("ex");
    }


}
