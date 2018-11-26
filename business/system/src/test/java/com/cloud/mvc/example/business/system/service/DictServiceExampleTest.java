package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.system.SystemApplication;
import com.cloud.mvc.example.business.system.entity.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DictServiceExampleTest {

    @Autowired
    DictServiceExample serviceExample;

    @Test
    public void countByExample() {
        long l = serviceExample.countByExample();
        System.out.println(l);
    }

    @Test
    public void deleteByExample() {
        serviceExample.deleteByExample();
    }

    @Test
    public void deleteByPrimaryKey() {
        serviceExample.deleteByPrimaryKey();
    }

    @Test
    public void insert() {
        serviceExample.insert();
    }

    @Test
    public void insertSelective() {
        int i = serviceExample.insertSelective();

    }

    @Test
    public void selectByExample() {
        List<Dict> dicts = serviceExample.selectByExample();
        dicts.stream().forEach(t -> System.out.println(t.toString()));
    }

    @Test
    public void selectByPrimaryKey() {
        Dict dict = serviceExample.selectByPrimaryKey();
        System.out.println(dict.toString());
    }

    @Test
    public void updateByExampleSelective() {
        serviceExample.updateByExampleSelective();
    }

    @Test
    public void updateByExample() {
        serviceExample.updateByExample();
    }

    @Test
    public void updateByPrimaryKeySelective() {
        serviceExample.updateByPrimaryKeySelective();
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void batchInsert() {

        serviceExample.batchInsert();

    }

    @Test
    public void batchInsertSelective() {
        serviceExample.batchInsertSelective();
    }

    @Test
    public void selectOneByExample() {
        serviceExample.selectOneByExample();
    }

    @Test
    public void upsert() {
        serviceExample.upsert();
    }

    @Test
    public void upsertSelective() {
        serviceExample.upsertSelective();
    }
}