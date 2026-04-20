package com.qk.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.Service.UserService;
import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.User;
import com.qk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户列表查询
     * @param userDto
     * @return
     */
    @Override
    public PageResult<User> listUser(UserDto userDto) {
        //1.开启分页
        PageHelper.startPage(userDto.getPage(), userDto.getPageSize());
        //2.从mapper查询数据
        List<User> userList = userMapper
                .selectByCondition(userDto.getName(),userDto.getStatus(),userDto.getPhone(),userDto.getDeptId());
        //3.组装数据
        PageInfo pageInfo = new PageInfo<>(userList);
        long total = pageInfo.getTotal();
        return new PageResult<>(total,userList);
    }

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        //设定初始密码，对密码做MD5加密处理
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()+"123").getBytes()));

        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
}
