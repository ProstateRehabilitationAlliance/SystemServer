package com.prostate.system.service.impl;

import com.prostate.system.entity.User;
import com.prostate.system.mapper.UserMapper;
import com.prostate.system.service.UserService;

import com.prostate.system.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 12:48
 * @Todo:  UserService服务接口的实现类
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 14:52
     * @todo:   根据用户名查询用户权限
     * @param:   * @param null
     */
    @Override
    public User findUserWihtUserName(String username) {
        return null;
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
        //获取输入的密码
        String oldpassword = user.getPassword();
        //生成盐值并保存到user.salt()中
        long date = new Date().getTime();
        String salt = String.valueOf(date);
        user.setSalt(salt);
        String newpassword = oldpassword+salt;
        //将用户密码和盐值加密
        String saltpassword = MD5Util.toMD5(newpassword);
        //将加密之后的密码set到user.password();
        //System.out.println("新的密码是"+saltpassword);
        user.setPassword(saltpassword);
        //System.out.println("此时的user密码是:"+user.getPassword());
        //System.out.println("此时的user密码是:"+user.getPassword());
        //user调用服务方法
        int r = userMapper.insertSelective(user);
        System.out.println("r的值是"+r);
        return r;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 13:49
     * @todo: 管理员登录
     * @param: 用户名和密码
     * @return:查询到相关的用户,则返回1,查不到返回0.
     */
    @Override
    public int userLogin(String username, String password) {
        //首先根据用户名获取用户的salt
        //将用户输入的密码和盐值重新加密
        //根据用户名和新的密码再次查询是否存在用户
    List list= userMapper.selectUserByUsernameAndPassword(username,password);

        if(list == null || list.size() == 0) {
            return 0;
        }
        return 1;
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
