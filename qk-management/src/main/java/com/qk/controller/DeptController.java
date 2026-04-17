package com.qk.controller;

import com.qk.Service.DeptService;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门管理控制器
 */
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 部门列表查询
     * @param name
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    public Result listDepts(String name, Integer status,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        PageResult<Dept> pageResult = deptService.listDepts(name,status,page,pageSize);
        return Result.success(pageResult);
    }

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable("id") Integer id){
        deptService.deleteDept(id);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getDept(@PathVariable("id") Integer id){
        Dept dept = deptService.getDept(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }
}
