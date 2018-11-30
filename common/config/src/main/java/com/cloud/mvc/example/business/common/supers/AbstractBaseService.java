package com.cloud.mvc.example.business.common.supers;

import com.cloud.mvc.example.business.common.config.message.PageInfo;
import com.cloud.mvc.example.business.common.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractBaseService<A extends BaseEntity, B> implements BaseService<A, B> {

    @Autowired
    protected BaseMapper<A, B> mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(A record) {
        record.setCreateDate(LocalDateTime.now());
        record.setCreateUserId(SessionUtils.getCurrentUserId());
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(A record) {
        record.setCreateDate(LocalDateTime.now());
        record.setCreateUserId(SessionUtils.getCurrentUserId());
        return mapper.insertSelective(record);
    }

    @Override
    public A selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(A record) {
        record.setModifyDate(LocalDateTime.now());
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(A record) {
        record.setModifyDate(LocalDateTime.now());
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        return mapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo paging(B countExample, B listExample) {
        Long count = mapper.countByExample(countExample);
        if(count < 1) return PageInfo.EMPTY;
        List<A> data = mapper.selectByExample(listExample);
        return PageInfo.create(count, data);
    }
}
