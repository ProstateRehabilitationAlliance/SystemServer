package com.prostate.system.mapper;

import com.prostate.system.entity.UserOrganization;

public interface UserOrganizationMapper {
    int insert(UserOrganization record);

    int insertSelective(UserOrganization record);
}