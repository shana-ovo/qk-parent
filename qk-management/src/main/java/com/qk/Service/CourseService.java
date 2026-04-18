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

    /**
     * 新增课程
     * @param course
     */
    void addCourse(Course course);

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    Course getCourseById(Integer id);

    /**
     * 更新课程
     * @param course
     */
    void updateCourse(Course course);
}
