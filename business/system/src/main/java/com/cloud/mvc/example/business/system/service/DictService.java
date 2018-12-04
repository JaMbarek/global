package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.common.config.message.PageInfo;
import com.cloud.mvc.example.business.common.supers.BaseService;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.entity.Dict;

/**
* Created by Administrator on 2018-11-30 16:44:24
*
*/
public interface DictService extends BaseService<Dict, DictExample> {

    /**
     * 分页查找
     * @param key
     * @return
     */
    PageInfo selectByPaging(String key);
}