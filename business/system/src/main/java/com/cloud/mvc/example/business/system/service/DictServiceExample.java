package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.system.dao.DictMapper;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.entity.DictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DictServiceExample {

    @Autowired
    DictMapper mapper;


    public long countByExample(){
        DictExample example = DictExample.create();
        example.createCriteria().andValueEqualTo("1");
        long a = mapper.countByExample(example);
        return a;
    }

    public int deleteByExample(){
        DictExample example = new DictExample();
        example.createCriteria().andKeyEqualTo("key");
        return mapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(){
        return mapper.deleteByPrimaryKey(1L);
    }

    public int insert(){
        Dict build = Dict.builder().createDate(LocalDateTime.now())
                .key("key")
                .value("value")
                .status(1).build();
        return mapper.insert(build);
    }

    public int insertSelective(){
        Dict dict = Dict.builder()
                .createDate(LocalDateTime.now())
                .key("select")
                .value("selectValue")
                .build();
        int res =  mapper.insertSelective(dict);
        System.out.println(dict.getId());
        return res;
    }

    public List<Dict> selectByExample(){
        DictExample example = new DictExample();
        example.createCriteria().andKeyEqualTo("key");
        return mapper.selectByExample(example);
    }

    public Dict selectByPrimaryKey(){
        return mapper.selectByPrimaryKey(1L);
    }

    public int updateByExampleSelective(){
        Dict dict = Dict.builder().key("update").build();
        DictExample example = DictExample.create();
        example.createCriteria().andKeyEqualTo("key");


        return mapper.updateByExampleSelective(dict, example);
    }

    public int updateByExample(){
        Dict dict = Dict.builder().key("update").id(1L).build();
        DictExample example = DictExample.create();
        example.createCriteria().andKeyEqualTo("key");
        return mapper.updateByExample(dict, example);
    }

    public int updateByPrimaryKeySelective(){
        return mapper.updateByPrimaryKeySelective(Dict.builder().createDate(LocalDateTime.now()).id(1L).build());
    }

    public int updateByPrimaryKey(){
        return 1;
    }

    public int batchInsert(){
        List<Dict> collect = IntStream.rangeClosed(1, 100)
                .mapToObj(t -> Dict.builder().status(1).createDate(LocalDateTime.now()).key("key" + t).value("value" + t).build())
                .collect(Collectors.toList());
        return mapper.batchInsert(collect);
    }

    public int batchInsertSelective(){
        List<Dict> collect = IntStream.rangeClosed(1, 100)
                .mapToObj(t -> Dict.builder().status(1).createDate(LocalDateTime.now()).key("key" + t).value("value" + t).build())
                .collect(Collectors.toList());
        return mapper.batchInsertSelective(collect, Dict.Column.key, Dict.Column.value, Dict.Column.createDate);
    }

    public Dict selectOneByExample(){
        DictExample example = DictExample.create();
        example.createCriteria().andKeyLikeBoth("value");
        return mapper.selectOneByExample(example);
    }

    public int upsert(){
        Dict record = Dict.builder().id(205L).value("update").build();
        mapper.upsert(record);

        Dict dict = Dict.builder().id(2066L).value("update").build();
        mapper.upsert(dict);
        return 1;
    }

    public int upsertSelective(){
        Dict record = Dict.builder().id(207L).value("update").build();
        mapper.upsertSelective(record);

        Dict dict = Dict.builder().id(2068L).value("update").build();
        mapper.upsertSelective(dict);
        return 1;
    }




}
