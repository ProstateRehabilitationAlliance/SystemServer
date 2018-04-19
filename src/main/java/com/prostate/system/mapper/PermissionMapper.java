package com.prostate.system.mapper;

import com.prostate.system.entity.Permission;

public interface PermissionMapper {
    int insert(Permission record);

    int insertSelective(Permission record);
}