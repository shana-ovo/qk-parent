package com.qk.Service;

import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.User;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 用户列表查询
     * @param userDto
     * @return
     */
    PageResult<User> listUser(UserDto userDto);

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);
}
