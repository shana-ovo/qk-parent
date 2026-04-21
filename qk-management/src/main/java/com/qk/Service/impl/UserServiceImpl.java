package com.qk.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.Service.UserService;
import com.qk.common.PageResult;
import com.qk.dto.UserDto;
import com.qk.entity.LoginResultVo;
import com.qk.entity.User;
import com.qk.exception.BusinessException;
import com.qk.mapper.UserMapper;
import com.qk.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 用户服务实现类
 */
@Slf4j
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

    /**
     * 批量删除用户
     * @param ids
     */
    @Override
    public void deleteUsers(List<Integer> ids) {
        userMapper.deleteByIds(ids);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> getAll() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

    /**
     * 根据角色标识查询用户列表
     * @param label
     * @return
     */
    @Override
    public List<User> getByRoleLabel(String label) {
        List<User> userList = userMapper.selectByRoleLabel(label);
        return userList;
    }

    /**
     * 根据deptId查询用户列表
     * @param deptId
     * @return
     */
    @Override
    public List<User> getByDeptId(String deptId) {
        List<User> userList = userMapper.selectByDeptId(deptId);
        return userList;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public LoginResultVo userLogin(User user) {
        //对密码处理
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User getUser = userMapper.selectByUnameAndPsw(user);
        if (getUser == null){
            throw new BusinessException("用户名或密码错误！");
        }
        if (getUser.getStatus() != 1){
            throw new BusinessException("用户被停用，或异常");
        }

        //设置用户token
        Map<String, Object> claims = new HashMap<>();
        log.info("{}-claims:{}",getClass(),claims);
        claims.put("userId",getUser.getId());
        claims.put("username",getUser.getUsername());
        String token = JwtUtils.generateToken(claims);

        //数据封装
        LoginResultVo loginResultVo = new LoginResultVo();
        loginResultVo.setId(getUser.getId());
        loginResultVo.setName(getUser.getName());
        loginResultVo.setUsername(getUser.getUsername());
        loginResultVo.setImage(getUser.getImage());
        loginResultVo.setRoleLabel(getUser.getRoleLabel());
        loginResultVo.setToken(token);
        return loginResultVo;
    }
}
