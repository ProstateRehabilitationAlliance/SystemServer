package com.prostate.system.service;

import com.prostate.system.entity.AnamnesisType;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 16:16 2018/4/24
 */
public interface AnamnesisTypeService extends BaseService<AnamnesisType>{

    List<AnamnesisType> findAll();
   List<AnamnesisType> selectByAnamnesisTypeName(String anamnesisTypeName);
}
