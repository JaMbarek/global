package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.system.dto.DictDto;
import com.cloud.mvc.example.business.system.entity.Dict;
import com.cloud.mvc.example.business.system.entity.DictExample;
import com.cloud.mvc.example.business.system.vo.DictVo;
import com.cloud.mvc.example.general.response.PageInfo;
import com.cloud.mvc.example.general.supers.BaseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DictService extends BaseService<Dict, DictExample> {

    /**
     * 保存
     * @param dictDto
     * @return
     */
    Mono<Integer> save(DictDto dictDto);


    Flux<Dict> getBeanByIds(List<Long> ids);


    Mono<PageInfo> selectByPaging(DictVo vo);
}
