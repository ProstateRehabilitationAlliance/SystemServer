package com.prostate.system.mapper;

import com.prostate.system.entity.Organization;

public interface OrganizationMapper {
    int insert(Organization record);

    int insertSelective(Organization record);
}