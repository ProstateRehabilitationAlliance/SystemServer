package com.prostate.system.service;

import com.prostate.system.entity.Permission;
import com.prostate.system.entity.Role;
import com.prostate.system.entity.User;
import com.prostate.system.entity.UserRole;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 11:53
 * @Todo:
 */

@Service
public interface UserService extends BaseService<User>{

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 13:13
     * @todo:   管理员注册
     * @param:   User对象
     * @return:  注册成功返回1,注册失败返回0
     */
    int insertSelective(User user);

//    /**
//     * @Author: bianyakun
//     * @Date: 2018/4/19 13:14
//     * @todo:   根据用户名和密码进行查询
//     * @param:   用户名和密码
//     * @return:  登录成功返回1,登录失败返回0
//     */
//    int userLogin(String username,String password);

    /**
     * @TODO: 根据用户名查找用户信息
     * @param username
     * @return  use对象
     */
   List<User> findUserWihtUserName(String username);
   // User findUserWihtUserName(String username);

    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 13:44
     * @todo:   根据用户名查询用户的id
     * @param:   * @param null
     */
    List<String> findUserIdByName(String username);


    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 13:47
     * @todo:   通过userId查询用户角色id,存进List集合
     * @param:   * @param null
     */
    List<UserRole> findRoleIdByUid(String userId);






    int updateSelective(User user);

    User selectById(String id);

    List<User> selectByParams(User user);

    int deleteById(String id);
}
