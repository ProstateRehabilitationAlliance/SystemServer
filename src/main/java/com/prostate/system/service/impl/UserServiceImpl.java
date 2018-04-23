package com.prostate.system.service.impl;

import com.prostate.system.entity.User;
import com.prostate.system.entity.UserRole;
import com.prostate.system.mapper.UserMapper;
import com.prostate.system.service.UserService;

import com.prostate.system.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 12:48
 * @Todo:  UserService服务接口的实现类
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<String> findUserIdByName(String username) {
        List<String> strings = new ArrayList<String>();
        strings= userMapper.findUserIdByName(username);  //UserMapper中的数据存在list中,但是只有一条
        return strings;
    }

    @Override
    public List<UserRole> findRoleIdByUid(String userId) {
        return null;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 14:52
     * @todo:   根据用户名查询用户
     * @param:   * @param null
     */
    @Override
    public List<User> findUserWihtUserName(String username) {
        List<User> users = userMapper.findUserWihtUserName(username);
        return users;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 13:47
     * @todo:  管理员注册
     * @param:   User对象
     * @return:注册成功返回1,注册失败返回0
     */
    @Override
    public int insertSelective(User user) {
        //获取输入的密码和用户名
        String password = user.getPassword();
        String username = user.getUsername();
        User user1= MD5Util.md5Password(username,password);
        //user调用服务方法
        int r = userMapper.insertSelective(user1);
        return r;
    }














    @Override
    public int updateSelective(User user) {
        return 0;
    }

    @Override
    public User selectById(String id) {
        return null;
    }

    @Override
    public List<User> selectByParams(User user) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
