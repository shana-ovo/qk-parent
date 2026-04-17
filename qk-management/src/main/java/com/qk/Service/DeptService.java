package com.qk.Service;

import com.qk.common.PageResult;
import com.qk.entity.Dept;

/**
 * 部门服务接口
 */
public interface DeptService {

    /**
     * 新增部门
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 部门列表查询
     * @param name
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    PageResult<Dept> listDepts(String name, Integer status, Integer page, Integer pageSize);
}
