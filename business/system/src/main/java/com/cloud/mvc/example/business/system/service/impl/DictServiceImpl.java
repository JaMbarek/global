package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.mvc.example.business.common.supers.AbstractBaseService;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.entity.Dict;

import java.util.Optional;

/**
* Created by Administrator on 2018-12-13 17:59:45
*
*/
@Service
public class DictServiceImpl extends AbstractBaseService<Dict, DictExample> implements DictService {


    @Override
    public DictDto findDictByKey(String key) {

        DictExample example = new DictExample();
        example.createCriteria().andKeyEqualTo(key);
        Optional.of(null);
        return mapper.selectOneByExample(example).map(DictDto.class);
    }
}