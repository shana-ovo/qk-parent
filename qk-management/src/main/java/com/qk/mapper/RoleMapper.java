package com.qk.mapper;


import com.qk.entity.Role;
import org.apache.ibatis.annotations.Mapper;
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
}
