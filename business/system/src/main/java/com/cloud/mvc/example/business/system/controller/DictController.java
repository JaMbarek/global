package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.system.dto.DictDto;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.vo.DictVo;
import com.cloud.mvc.example.general.response.PageInfo;
import com.cloud.mvc.example.general.supers.BaseSystemController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.cloud.mvc.example.general.constants.UrlConstants.SystemUrlConstants.SYSTEM_DICT_URL;

@RestController
@RequestMapping(SYSTEM_DICT_URL)
@Api(tags = "系统常量接口")
public class DictController extends BaseSystemController {



    @Autowired
    DictService service;

    @ApiOperation("添加系统常量")
    @PostMapping
    public Mono<ResponseEntity> save(@Validated DictDto dictDto) throws Exception {
         Mono<Integer> mono = service.save(dictDto);
         return mono.map(t -> ResponseEntity.status(HttpStatus.CREATED).body(true));
    }

    @GetMapping("/paging")
    public Mono<ResponseEntity<PageInfo>> paging(@RequestParam DictVo vo){
        Mono<PageInfo> data = service.selectByPaging(vo);
        return data.map(t -> ResponseEntity.status(HttpStatus.OK).body(t));
    }





}
