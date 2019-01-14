package com.cloud.mvc.example.business.system.service;

import com.cloud.mvc.example.business.common.supers.BaseService;
import com.cloud.mvc.example.business.domain.dto.user.RoleDto;
import com.cloud.mvc.example.business.system.entity.Role;
import com.cloud.mvc.example.business.system.entity.RoleExample;

import java.util.List;

public interface RoleService extends BaseService<Role, RoleExample> {
    RoleDto findRoleByName(String name);

    List<RoleDto> findRolesByName(String name);
}
