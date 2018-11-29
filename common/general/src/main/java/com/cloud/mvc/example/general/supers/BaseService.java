package com.cloud.mvc.example.general.supers;

import com.cloud.mvc.example.business.domain.enums.DeleteOperatrs;
import com.cloud.mvc.example.general.response.PageInfo;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BaseService<A extends BaseEntity, B> {

    long countByExample(B example);

    int deleteByExampleLogic(A record, B example);

    int deleteByExamplePhysic(B example);

    int deleteByPrimaryKeyLogic(A record);

    int deleteByPrimaryKeyPhysic(Long id);

    int insert(A record);

    int insertSelective(A record);

    List<A> selectByExample(B example);

    A selectByPrimaryKey(Long id);

    int updateByExampleSelective(A record, B example);

    int updateByExample(A record, B example);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);

    PageInfo paging(B countExample, B listExample);

}
