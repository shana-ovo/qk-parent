package com.qk.controller;

import com.qk.Service.DeptService;
import com.qk.common.Result;
import com.qk.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }
}
