package com.qk.Service;

import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.User;

import java.util.List;

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

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteUsers(List<Integer> ids);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAll();

    /**
     * 根据角色标识查询用户列表
     * @param label
     * @return
     */
    List<User> getByRoleLabel(String label);
}
