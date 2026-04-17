package com.qk.mapper;

import com.qk.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, status, create_time, update_time) " +
            "VALUE (#{name},#{status},#{createTime},#{updateTime})")
    void insertDept(Dept dept);
}
