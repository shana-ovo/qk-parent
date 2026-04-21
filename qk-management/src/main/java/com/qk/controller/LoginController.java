package com.qk.controller;

import com.qk.Service.UserService;
import com.qk.common.Result;
import com.qk.entity.LoginResultVo;
import com.qk.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录控制器
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user){
        log.info("用户登录：{}",user);
        LoginResultVo resultVo = userService.userLogin(user);
        return Result.success(resultVo);
    }
}
