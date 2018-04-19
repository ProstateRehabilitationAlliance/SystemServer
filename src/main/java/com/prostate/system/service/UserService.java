package com.prostate.system.service;

import com.prostate.system.entity.User;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 11:53
 * @Todo:
 */

@Transactional
public interface UserService extends BaseService<User>{

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 13:13
     * @todo:   管理员注册
     * @param:   User对象
     * @return:  注册成功返回1,注册失败返回0
     */
    int insertSelective(User user);

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 13:14
     * @todo:   管理员登录
     * @param:   用户名和密码
     * @return:  登录成功返回1,登录失败返回0
     */
    int userLogin(String username,String password);

    /**
     * @TODO: 根据用户名查找用户信息
     * @param username
     * @return  use对象
     */
    User findUserWihtUserName(String username);
    int updateSelective(User user);

    User selectById(String id);

    List<User> selectByParams(User user);

    int deleteById(String id);
}
