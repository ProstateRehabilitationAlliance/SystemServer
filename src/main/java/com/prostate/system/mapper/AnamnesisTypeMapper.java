package com.prostate.system.mapper;

import com.prostate.system.entity.AnamnesisType;

public interface AnamnesisTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(AnamnesisType record);

    int insertSelective(AnamnesisType record);

    AnamnesisType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AnamnesisType record);

    int updateByPrimaryKey(AnamnesisType record);
}