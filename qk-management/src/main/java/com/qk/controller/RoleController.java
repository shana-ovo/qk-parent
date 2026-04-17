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

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping
    public Result addRole(@RequestBody Role role) {
        log.info("添加角色: {}", role);
        roleService.addRole(role);
        return Result.success();
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getRole(@PathVariable("id") Integer id){
        log.info("根据id查询角色，id:{}",id);
        Role role = roleService.getRole(id);
        return Result.success(role);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping
    public Result updateRole(@RequestBody Role role){
        log.info("修改角色：{}",role);
        roleService.updateRole(role);
        return Result.success();
    }
}
