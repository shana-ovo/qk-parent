package com.qk.mapper;

import com.qk.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门数据访问接口
 */
@Mapper
public interface DeptMapper {

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, status, create_time, update_time) " +
            "VALUE (#{name},#{status},#{createTime},#{updateTime})")
    void insertDept(Dept dept);

    /**
     * 部门列表查询
     * @param name
     * @param status
     * @return
     */
    List<Dept> selectByCondition( String name,  Integer status);

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
