package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.common.config.message.PageInfo;
import com.cloud.mvc.example.business.common.request.PageHolder;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.mvc.example.business.common.supers.AbstractBaseService;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.entity.Dict;

/**
* Created by Administrator on 2018-11-30 16:44:24
*
*/
@Service
public class DictServiceImpl extends AbstractBaseService<Dict, DictExample> implements DictService {

    @Autowired
    PageHolder holder;

    @Override
    public PageInfo selectByPaging(String key) {
        DictExample example = new DictExample();
        DictExample.Criteria criteria = example.createCriteria();

        if(!Strings.isNullOrEmpty(key)){
            criteria.andKeyLikeBoth(key);
        }

        DictExample listExample = new DictExample();

        if(!Strings.isNullOrEmpty(key)){
            listExample.createCriteria().andKeyLikeBoth(key);
        }
        listExample.start(holder.getStart()).limit(holder.getLimit());

        return paging(example, listExample);
    }
}