package com.prostate.system.service;

import com.prostate.system.entity.AnamnesisIllness;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 19:07 2018/4/24
 */
public interface AnamnesisIllnessService extends BaseService<AnamnesisIllness> {

    List<AnamnesisIllness> findAll();
    List<AnamnesisIllness> selectByAnamnesisIllnessName(String anamnesisIllnessName);
}
