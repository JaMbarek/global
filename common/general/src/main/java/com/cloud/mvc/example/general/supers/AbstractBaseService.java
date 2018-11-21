package com.cloud.mvc.example.general.supers;

import com.cloud.mvc.example.business.domain.enums.DeleteOperatrs;
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
    public int deleteByExample(B example, DeleteOperatrs type) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id, DeleteOperatrs type) {
        return mapper.deleteByPrimaryKey(id );
    }

    @Override
    public int insert(A record) {
        record.setCreateDate(LocalDateTime.now());
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(A record) {
        record.setCreateDate(LocalDateTime.now());
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
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(A record, B example) {
        record.setModifyDate(LocalDateTime.now());
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(A record) {
        record.setModifyDate(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(A record) {
        record.setModifyDate(LocalDateTime.now());
        return mapper.updateByPrimaryKey(record);
    }
}
