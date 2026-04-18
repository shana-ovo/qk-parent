package com.qk.Service;

import com.qk.common.PageResult;
import com.qk.dto.CourseDto;
import com.qk.entity.Course;

/**
 * 课程管理服务接口
 */
public interface CourseService {

    /**
     * 课程列表查询
     * @param courseDto
     * @return
     */
    PageResult<Course> listCourse(CourseDto courseDto);

    /**
     * 根据id删除课程
     * @param id
     */
    void deleteCourse(Integer id);
}
