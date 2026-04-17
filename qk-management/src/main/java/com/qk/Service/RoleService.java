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
}
