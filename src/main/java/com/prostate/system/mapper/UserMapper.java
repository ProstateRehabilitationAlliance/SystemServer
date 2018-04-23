package com.prostate.system.mapper;

import com.prostate.system.entity.User;
import com.prostate.system.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 10:12
 * @Todo:  User 的持久化
 */
@Repository
public interface UserMapper {

    int insert(User record);

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 11:15
     * @todo:   注册管理员账号
     * @param:   User对象
     */
    int insertSelective(User user);

    /**
     * @TODO: 根据用户名和密码查询是否有这个用户
     * @param username  用户名
     * @param password  密码
     * @return  如果存在用户返回1,不存在返回0.
     */
    List selectUserByUsernameAndPassword(String username, String password);

    /**
     * @TODO: 根据用户名查询是否有这个用户
     * @param username  用户名
     * @return  如果存在用户返回1,不存在返回0.
     */
   List<User> findUserWihtUserName(String username);


    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 15:17
     * @todo:   根据用户名查询用户的id
     * @param:   * @param null
     */
    List<String> findUserIdByName(String username);

    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 15:30
     * @todo: 根据userId 查询角色id
     * @param:   * @param null
     */
    List<UserRole> findRoleIdByUid(String userId);
}