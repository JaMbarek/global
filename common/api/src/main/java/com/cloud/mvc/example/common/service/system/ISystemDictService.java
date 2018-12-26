package com.cloud.mvc.example.common.service.system;

import com.cloud.mvc.example.business.domain.constants.UrlConstants;
import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.business.domain.resp.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ISystemDictService {

    String path = UrlConstants.SystemUrlConstants.SYSTEM_DICT_URL;

    @GetMapping("findDictByKey")
    R<DictDto> findDictByKey(@RequestParam("key") String key);



}
