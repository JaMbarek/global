package com.cloud.mvc.example.common.service.system;

import com.cloud.mvc.example.business.domain.entity.system.Dict;

public interface DictSuperService {

    Dict getValue(String key);

    boolean exists(String key);



}
