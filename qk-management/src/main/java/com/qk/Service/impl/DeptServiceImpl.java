package com.qk.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.Service.DeptService;
import com.qk.common.PageResult;
import com.qk.entity.Dept;
import com.qk.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门服务实现类
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 新增部门
     * @param dept
     */
    @Override
    public void addDept(Dept dept) {
        //数据处理
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);

    }

    @Override
    public PageResult<Dept> listDepts(String name, Integer status, Integer page, Integer pageSize) {
        //1.开启分页
        PageHelper.startPage(page,pageSize);
        //2.调用mapper
        List<Dept> depts = deptMapper.selectByCondition(name,status);
        //3.获取总记录数
        PageInfo<Dept> pageInfo = new PageInfo<>(depts);
        long total = pageInfo.getTotal();
        List<Dept> deptList = pageInfo.getList();

        return new PageResult<>(total,deptList);
    }

    /**
     * 根据id删除部门
     * @param id
     */
    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteById(id);
    }
}
