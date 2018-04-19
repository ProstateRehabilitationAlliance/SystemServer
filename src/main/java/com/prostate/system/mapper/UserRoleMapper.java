package com.prostate.system.mapper;

import com.prostate.system.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}