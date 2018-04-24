package com.prostate.system.service.impl;

import com.prostate.system.entity.AnamnesisType;
import com.prostate.system.service.AnamnesisTypeService;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 16:17 2018/4/24
 */
public class AnamnesisTypeServiceImpl  implements AnamnesisTypeService{
    @Override
    public int insertSelective(AnamnesisType anamnesisType) {
        return 0;
    }

    @Override
    public int updateSelective(AnamnesisType anamnesisType) {
        return 0;
    }

    @Override
    public AnamnesisType selectById(String id) {
        return null;
    }

    @Override
    public List<AnamnesisType> selectByParams(AnamnesisType anamnesisType) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
