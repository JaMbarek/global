package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.system.dao.DictMapper;
import com.cloud.mvc.example.business.system.service.DictService;
import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DictServiceImpl implements DictService {

    @Override
    public Mono<Integer> save(DictDto dictDto) {
        return null;
    }
}
