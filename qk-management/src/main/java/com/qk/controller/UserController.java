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
}
