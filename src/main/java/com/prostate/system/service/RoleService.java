package com.prostate.system.service;

import com.prostate.system.entity.Role;
import com.prostate.system.entity.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @Author: bianyakun
 * @Date: 2018/4/20 14:00
 * @Todo:
 */

@Transactional
@Service
public interface RoleService extends  BaseService<Role>{


    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 14:23
     * @todo: 根据角色id查询权限id
     * @param:   * @param null
     */
    List<String> findPermissionIdByRoleId(String roleId);

    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 13:55
     * @todo:  通过角色id查询角色
     * @param:   * @param null
     */
    String findRoleByRoleId(String  roleId);
}
