package com.prostate.system.service.impl;

import com.prostate.system.entity.Role;
import com.prostate.system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/23 9:12
 * @Todo:
 */



@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<String> findPermissionIdByRoleId(String roleId) {
        return null;
    }

    @Override
    public String findRoleByRoleId(String roleId) {
        return null;
    }

    @Override
    public int insertSelective(Role role) {
        return 0;
    }

    @Override
    public int updateSelective(Role role) {
        return 0;
    }

    @Override
    public Role selectById(String id) {
        return null;
    }

    @Override
    public List<Role> selectByParams(Role role) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
