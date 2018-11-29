package com.cloud.mvc.example.general.supers;

import com.cloud.mvc.example.general.response.PageInfo;
import com.cloud.mvc.example.general.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractBaseService<A extends BaseEntity, B> implements BaseService<A, B>{

    @Autowired
    BaseMapper<A, B> mapper;

    @Override
    public long countByExample(B example) {
        return mapper.countByExample(example);
    }


    @Override
    public int deleteByExampleLogic(A record, B example) {
        record.setStatus(0);
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        record.setModifyDate(LocalDateTime.now());
        return mapper.updateByExample(record, example);
    }

    @Override
    public int deleteByExamplePhysic(B example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKeyLogic(A record) {
        record.setStatus(0);
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        record.setModifyDate(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKeyPhysic(Long id) {
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
    public List<A> selectByExample(B example) {
        return mapper.selectByExample(example);
    }

    @Override
    public A selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(A record, B example) {
        record.setModifyDate(LocalDateTime.now());
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(A record, B example) {
        record.setModifyDate(LocalDateTime.now());
        record.setModifyUserId(SessionUtils.getCurrentUserId());
        return mapper.updateByExample(record, example);
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
