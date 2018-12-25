package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.common.service.system.ISystemDictService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping(DictController.path)
@SuppressWarnings("all")
public class DictController implements ISystemDictService {

    @Autowired
    DictService service;

    @Override
    @ApiOperation(value = "根据key值查询value", response = DictDto.class)
    public DictDto findDictByKey(@NotEmpty String key) {
        return service.findDictByKey(key);
    }
}
