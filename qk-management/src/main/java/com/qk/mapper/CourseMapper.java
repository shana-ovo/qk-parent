package com.qk.mapper;

import com.qk.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 课程管理数据访问接口
 */
@Mapper
public interface CourseMapper {

    /**
     * 课程列表查询
     * @param name
     * @param subject
     * @param target
     * @return
     */
    List<Course> getCourses(String name, Integer subject, Integer target);

    /**
     * 根据id删除课程
     * @param id
     */
    @Delete("delete from course where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加课程
     * @param course
     */
    @Insert("insert into course(subject, name, price, target, description, create_time, update_time) " +
            "VALUE (#{subject},#{name},#{price},#{target},#{description},#{createTime},#{updateTime})")
    void insert(Course course);
}
