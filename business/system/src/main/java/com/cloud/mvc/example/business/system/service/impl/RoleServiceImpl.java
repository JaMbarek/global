package com.cloud.mvc.example.business.system.service.impl;

import com.cloud.mvc.example.business.common.supers.AbstractBaseService;
import com.cloud.mvc.example.business.domain.dto.user.RoleDto;
import com.cloud.mvc.example.business.system.entity.Role;
import com.cloud.mvc.example.business.system.entity.RoleExample;
import com.cloud.mvc.example.business.system.service.RoleService;
import com.cloud.mvc.example.utils.mapper.BeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends AbstractBaseService<Role, RoleExample> implements RoleService {


    @Override
    public RoleDto findRoleByName(String name) {
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(name);
        return mapper.selectOneByExample(example).map(RoleDto.class);
    }

    @Override
    public List<RoleDto> findRolesByName(String name) {
        RoleExample example = new RoleExample();
        example.createCriteria().andNameLikeBoth(name);
        return mapper.selectByExample(example).stream().map(t -> BeanMapper.map(t, RoleDto.class)).collect(Collectors.toList());
    }
}
