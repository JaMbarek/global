package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.general.supers.AbstractBaseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DictServiceImpl extends AbstractBaseService<Dict, DictExample> implements DictService {

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
}
