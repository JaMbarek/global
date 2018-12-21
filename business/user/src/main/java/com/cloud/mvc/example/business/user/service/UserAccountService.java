package com.cloud.mvc.example.business.user.service;

import com.cloud.mvc.example.business.common.utils.BeanMapper;
import com.cloud.mvc.example.business.domain.dto.UserAccountDto;
import com.cloud.mvc.example.business.user.dao.UserAccountMapper;
import com.cloud.mvc.example.business.user.entity.UserAccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    UserAccountMapper mapper;

    public UserAccountDto findUserAccountByPhone(String phone) {

        UserAccountExample example = new UserAccountExample();
        example.createCriteria().andPhoneEqualTo(phone);

        return mapper.selectByExample(example).stream().findFirst()
                .map(t -> BeanMapper.map(t, UserAccountDto.class))
                .orElse(null);


    }
}
