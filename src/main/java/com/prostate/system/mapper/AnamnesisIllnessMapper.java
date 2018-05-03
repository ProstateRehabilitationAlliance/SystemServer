package com.prostate.system.mapper;

import com.prostate.system.entity.AnamnesisIllness;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnamnesisIllnessMapper {
    int deleteByPrimaryKey(String id);

    int insert(AnamnesisIllness record);

    int insertSelective(AnamnesisIllness record);

    AnamnesisIllness selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AnamnesisIllness record);

    int updateByPrimaryKey(AnamnesisIllness record);

    List<AnamnesisIllness> findAll();

    List<AnamnesisIllness> selectByAnamnesisIllnessName(String anamnesisIllnessName);
}