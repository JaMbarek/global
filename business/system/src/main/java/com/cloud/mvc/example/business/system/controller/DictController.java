package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.general.supers.BaseSystemController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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







}
