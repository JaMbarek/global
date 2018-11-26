package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.system.dto.DictDto;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.system.vo.DictVo;
import com.cloud.mvc.example.general.response.PageInfo;
import com.cloud.mvc.example.general.supers.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DictServiceImpl extends AbstractBaseService<Dict, DictExample> implements DictService {


    ServerWebExchange exchange;

    @Override
    public Mono<Integer> save(DictDto dictDto) {
        return null;
    }


    @Override
    public Flux<Dict> getBeanByIds(List<Long> ids) {
        DictExample example = new DictExample();
        example.createCriteria().andIdIn(ids);
        return Flux.fromIterable(super.selectByExample(example));
    }


    @Override
    public Mono<PageInfo> selectByPaging(DictVo vo) {
        DictExample countExample = new DictExample();
        countExample.createCriteria().andKeyEqualTo(vo.getKey())
                .andValueEqualTo(vo.getValue());

        DictExample listExaple = new DictExample();
        listExaple.createCriteria().andKeyEqualTo(vo.getKey())
                .andValueEqualTo(vo.getValue());
        listExaple.start(1).limit(10);

        return paging(countExample, listExaple);
    }
}
