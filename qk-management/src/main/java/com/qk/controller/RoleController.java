package com.qk.controller;

import com.qk.Service.RoleService;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据ID删除角色
     * @param id 角色ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public Result deleteRole(@PathVariable Integer id) {
        log.info("删除角色: id={}", id);
        roleService.deleteRole(id);
        return Result.success();
    }

    @PostMapping
    public Result addRole(@RequestBody Role role) {
        log.info("添加角色: {}", role);
        roleService.addRole(role);
        return Result.success();
    }
}
