package com.qk.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.Service.RoleService;
import com.qk.common.PageResult;
import com.qk.entity.Role;
import com.qk.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色服务实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 角色列表查询
     * @param name
     * @param lable
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageResult<Role> listRoles(String name, String label, int page, int pageSize) {
        //1.开启分页
        PageHelper.startPage(page,pageSize);
        //2.得到查询结果
        List<Role> roles = roleMapper.selectByCondition(name,label);
        //3.封装返回数据
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        long total = pageInfo.getTotal();
        List<Role> roleList = pageInfo.getList();
        return new PageResult<>(total,roleList);
    }

    /**
     * 根据id删除角色
     * @param id
     */
    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteById(id);
    }

    /**
     * 新增角色
     * @param role
     */
    @Override
    public void addRole(Role role) {
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insert(role);
    }
}
