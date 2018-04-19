package com.prostate.system.mapper;

import com.prostate.system.entity.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}