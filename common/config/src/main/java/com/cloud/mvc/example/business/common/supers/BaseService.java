package com.cloud.mvc.example.business.common.supers;


import com.cloud.mvc.example.business.common.config.message.PageInfo;

public interface BaseService<A extends BaseEntity, B> {

    int deleteByPrimaryKey(Long id);

    int insert(A record);

    int insertSelective(A record);

    A selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);

    PageInfo paging(B countExample, B listExample);

}
