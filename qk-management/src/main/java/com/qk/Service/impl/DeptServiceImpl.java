package com.qk.Service.impl;

import com.qk.Service.DeptService;
import com.qk.entity.Dept;
import com.qk.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
