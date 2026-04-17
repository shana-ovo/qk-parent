package com.qk.Service;

import com.qk.common.PageResult;
import com.qk.entity.Role;

/**
 * 角色服务接口
 */
public interface RoleService {

    /**
     * 角色列表查询
     * @param name
     * @param label
     * @param page
     * @param pageSize
     * @return
     */
    PageResult<Role> listRoles(String name, String label, int page, int pageSize);

    /**
     * 根据id查询角色
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    Role getRole(Integer id);
}
