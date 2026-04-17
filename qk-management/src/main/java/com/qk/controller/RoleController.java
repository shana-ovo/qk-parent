package com.qk.controller;

import com.qk.Service.RoleService;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * 角色管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 角色列表查询
     * @param name
     * @param lable
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    public Result listRoles(String name, String label,
                                      @RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10")int pageSize){
        log.info("条件分页查询角色: name={}, lable={}, page={}, pageSize={}", name, label, page, pageSize);

        PageResult<Role> pageResult = roleService.listRoles(name, label, page, pageSize);
        return Result.success(pageResult);
    }
}
