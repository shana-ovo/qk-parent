package com.qk.mapper;


import com.qk.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
