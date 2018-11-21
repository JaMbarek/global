package com.cloud.mvc.example.general.supers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator on 2018/11/21
*/
public interface BaseMapper<A extends BaseEntity, B> {
    long countByExample(B example);

    int deleteByExample(B example);

    int deleteByPrimaryKey(Long id);

    int insert(A record);

    int insertSelective(A record);

    List<A> selectByExample(B example);

    A selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") A record, @Param("example") B example);

    int updateByExample(@Param("record") A record, @Param("example") B example);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);
}