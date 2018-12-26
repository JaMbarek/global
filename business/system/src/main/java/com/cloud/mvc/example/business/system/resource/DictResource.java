package com.cloud.mvc.example.business.system.resource;

import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.business.domain.resp.R;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.common.service.system.ISystemDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping(DictResource.path)
@SuppressWarnings("all")
public class DictResource implements ISystemDictService {

    @Autowired
    DictService service;

    @Override
    public R<DictDto> findDictByKey(@NotEmpty String key) {
        return R.success(service.findDictByKey(key));
    }
}
