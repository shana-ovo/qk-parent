package com.qk.mapper;


import com.qk.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色数据访问接口
 */
@Mapper
public interface RoleMapper {
    /**
     * 角色列表查询
     * @param name
     * @param label
     * @return
     */
    List<Role> selectByCondition(String name, String label);

    /**
     * 根据id删除角色
     * @param id
     */
    @Delete("DELETE FROM role WHERE id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增角色
     * @param role
     */
    @Insert("insert into role(name, label, remark, create_time, update_time) " +
            "value (#{name},#{label},#{remark},#{createTime},#{updateTime})")
    void insert(Role role);

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Select("select id, name, label, remark, create_time, update_time from role where id = #{id}")
    Role getById(Integer id);

    /**
     * 修改角色
     * @param role
     */
    void update(Role role);

    /**
     * 查询所有角色
     * @return
     */
    @Select("select id, name, label, remark, create_time, update_time from role")
    List<Role> getAll();
}
