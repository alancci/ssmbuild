package com.project.service.impl;

import com.project.dao.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;

import javax.annotation.Resource;
/**
 * @Description 方法(或接口)是
 * @Author  haojiaxing
 * @Date   2020/7/21 14:10
 **/
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(User user) {
        return  userMapper.login(user);
    }
}
