package com.qk.mapper;


import com.qk.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户数据访问接口
 */
@Mapper
public interface UserMapper {

    /**
     * 用户列表查询
     * @param name
     * @param status
     * @param phone
     * @param deptId
     * @return
     */
    List<User> selectByCondition(@Param("name") String name, @Param("status") Integer status, @Param("phone") String phone, @Param("deptId") Integer deptId);

    /**
     * 新增用户
     * @param user
     */
    @Insert("insert into user(username, password, name, phone, email, gender, status, dept_id, role_id, image, remark, create_time, update_time) " +
            "value (#{username},#{password},#{name},#{phone},#{email},#{gender},#{status},#{deptId},#{roleId},#{image},#{remark},#{createTime},#{updateTime})")
    void insert(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select id, username, password, name, phone, email, gender, status, dept_id, role_id, image, remark, create_time, update_time" +
            " from user where id = #{id}")
    User selectById(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select u.id, u.username, u.password, u.name, u.phone, u.email, u.gender, u.status, u.dept_id, " +
                "u.role_id, u.image, u.remark, u.create_time, u.update_time, d.name dept_name, r.name role_name " +
            "from user u " +
            "left join dept d on u.dept_id=d.id " +
            "left join role r on u.role_id = r.id")
    List<User> selectAll();

    /**
     * 根据角色标识查询用户列表
     * @param label
     * @return
     */
    @Select("select u.id, u.username, u.password, u.name, u.phone, u.email, u.gender, u.status, u.dept_id, " +
            "u.role_id, u.image, u.remark, u.create_time, u.update_time, d.name dept_name, r.name role_name " +
            "from user u " +
            "join dept d on u.dept_id=d.id " +
            "join role r on u.role_id = r.id" +
            " where r.label like concat('%',#{label},'%')")
    List<User> selectByRoleLabel(String label);

    /**
     * 根据deptId查询用户列表
     * @param deptId
     * @return
     */
    @Select("select u.id, u.username, u.password, u.name, u.phone, u.email, u.gender, u.status, u.dept_id, " +
            "u.role_id, u.image, u.remark, u.create_time, u.update_time, d.name dept_name, r.name role_name " +
            "from user u " +
            "join dept d on u.dept_id=d.id " +
            "join role r on u.role_id = r.id" +
            " where dept_id = #{deptId}")
    List<User> selectByDeptId(String deptId);
}
