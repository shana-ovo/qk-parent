package com.qk.controller;

import com.qk.Service.impl.CourseServiceImpl;
import com.qk.common.Result;
import com.qk.dto.CourseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 课程管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    /**
     * 课程列表查询
     * @param courseDto
     * @return
     */
    @GetMapping
    public Result listCourse(CourseDto courseDto){
        log.info("课程列表查询：{}",courseDto);
        return Result.success(courseService.listCourse(courseDto));
    }

    /**
     * 根据id删除课程
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteCourse(@PathVariable("id") Integer id){
        log.info("根据id删除课程：{}",id);
        courseService.deleteCourse(id);
        return Result.success();
    }
}
