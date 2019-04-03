package com.cloud.mvc.example.business.system.resource;

import com.cloud.mvc.example.business.domain.dto.user.RoleDto;
import com.cloud.mvc.example.business.domain.resp.R;
import com.cloud.mvc.example.business.system.service.RoleService;
import com.cloud.mvc.example.common.service.system.IRoleService;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(RoleResource.path)
@SuppressWarnings("all")
public class RoleResource implements IRoleService {


    private static final Logger logger = LoggerFactory.getLogger(RoleResource.class);

    @Autowired
    RoleService service;

    @Override
    public R<RoleDto> findRoleByName(@RequestParam("name") String name) {

        logger.debug("开始查询角色信息：{}", name);

        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.from(Try.of(() -> new RoleDto("abc")));
    }

    @Override
    public R<List<RoleDto>> findRolesByName(@RequestParam("name") String name) {
        return R.from(Try.of(() -> service.findRolesByName(name)));
    }
}
