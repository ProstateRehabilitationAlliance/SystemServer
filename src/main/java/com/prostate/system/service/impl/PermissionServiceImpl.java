package com.prostate.system.service.impl;

import com.prostate.system.entity.Permission;
import com.prostate.system.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/23 9:10
 * @Todo:
 */


@Service
public class PermissionServiceImpl implements PermissionService{
    @Override
    public Permission findPermissionById(String permissionId) {
        return null;
    }

    @Override
    public int insertSelective(Permission permission) {
        return 0;
    }

    @Override
    public int updateSelective(Permission permission) {
        return 0;
    }

    @Override
    public Permission selectById(String id) {
        return null;
    }

    @Override
    public List<Permission> selectByParams(Permission permission) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
