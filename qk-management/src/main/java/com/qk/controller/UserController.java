package com.qk.controller;

import com.qk.Service.UserService;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.dto.UserDto;
import com.qk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户列表查询
     * @param userDto
     * @return
     */
    @GetMapping
    public Result listUser(UserDto userDto) {
        log.info("用户列表查询：userDto：{}",userDto);
        PageResult<User> pageResult = userService.listUser(userDto);
        return Result.success(pageResult);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result addUser(@RequestBody User user) {
        log.info("新增用户：{}",user);
        userService.addUser(user);
        return  Result.success();
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteUsers(@PathVariable("ids") List<Integer> ids){
        log.info("根据id批量删除用户：{}",ids);
        userService.deleteUsers(ids);
        return Result.success();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getUser(@PathVariable("id") Integer id) {
        log.info("根据id查询用户：{}",id);
        return Result.success(userService.getUser(id));
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping
    public Result updateUser(@RequestBody User user) {
        log.info("修改用户：{}",user);
        userService.updateUser(user);
        return Result.success();
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/list")
    public Result getAll() {
        log.info("查询所有用户");
        List<User> userList = userService.getAll();
        log.info("查询所有用户结果：{}",userList);
        return Result.success(userList);
    }

    /**
     *
     * 根据roleLabel（角色标识）查询用户列表
     * @param label
     * @return
     */
    @GetMapping("/role/{roleLabel}")
    public Result getByRoleLabel(@PathVariable("roleLabel")String label) {
        log.info("根据roleLabel（角色标识）查询用户列表:{}",label);
        List<User> userList = userService.getByRoleLabel(label);
        return Result.success(userList);
    }
}
