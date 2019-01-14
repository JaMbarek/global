package com.cloud.mvc.example.common.service.system;

import com.cloud.mvc.example.business.domain.constants.UrlConstants;
import com.cloud.mvc.example.business.domain.dto.user.RoleDto;
import com.cloud.mvc.example.business.domain.resp.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IRoleService {

    String path = UrlConstants.SystemUrlConstants.SYSTEM_ROLE_URL;


    @GetMapping("/findRoleByName")
    R<RoleDto> findRoleByName(@RequestParam("name") String name);


    @GetMapping("/findRolesByName")
    R<List<RoleDto>> findRolesByName(@RequestParam("name") String name);




}
