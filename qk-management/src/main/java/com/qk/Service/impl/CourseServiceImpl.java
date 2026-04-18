package com.qk.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.Service.CourseService;
import com.qk.common.PageResult;
import com.qk.dto.CourseDto;
import com.qk.entity.Course;
import com.qk.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 课程管理服务实现类
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 课程列表查询
     * @param courseDto
     * @return
     */
    @Override
    public PageResult<Course> listCourse(CourseDto courseDto) {
        //1.开启分页
        PageHelper.startPage(courseDto.getPage(),courseDto.getPageSize());
        //2.条件查询课程信息
        List<Course> courseList = courseMapper
                .getCourses(courseDto.getName(),courseDto.getSubject(),courseDto.getTarget());
        //3.获取总记录
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);

        return new PageResult<>(pageInfo.getTotal(),courseList);
    }

    /**
     * 根据id删除课程
     * @param id
     */
    @Override
    public void deleteCourse(Integer id) {
        courseMapper.deleteById(id);
    }

    /**
     * 新增课程
     * @param course
     */
    @Override
    public void addCourse(Course course) {
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.insert(course);
    }

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @Override
    public Course getCourseById(Integer id) {
        return courseMapper.getById(id);
    }

    /**
     * 更新课程
     * @param course
     */
    @Override
    public void updateCourse(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.update(course);
    }

    /**
     * 查询所有课程
     * @return
     */
    @Override
    public List<Course> findAll() {
        List<Course> courseList = courseMapper.selectAll();
        return courseList;
    }
}
