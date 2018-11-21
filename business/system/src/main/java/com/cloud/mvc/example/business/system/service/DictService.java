package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import reactor.core.publisher.Mono;

public interface DictService {

    /**
     * 保存
     * @param dictDto
     * @return
     */
    Mono<Integer> save(DictDto dictDto);
}
