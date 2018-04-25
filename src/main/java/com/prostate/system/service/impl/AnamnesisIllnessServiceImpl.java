package com.prostate.system.service.impl;

import com.prostate.system.entity.AnamnesisIllness;
import com.prostate.system.mapper.AnamnesisIllnessMapper;
import com.prostate.system.service.AnamnesisIllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 19:08 2018/4/24
 */
@Service
public class AnamnesisIllnessServiceImpl implements AnamnesisIllnessService {
    @Autowired
    private AnamnesisIllnessMapper anamnesisIllnessMapper;
    @Override
    public int insertSelective(AnamnesisIllness anamnesisIllness) {
        return anamnesisIllnessMapper.insertSelective(anamnesisIllness);
    }

    @Override
    public int updateSelective(AnamnesisIllness anamnesisIllness) {
        return anamnesisIllnessMapper.updateByPrimaryKeySelective(anamnesisIllness);
    }

    @Override
    public AnamnesisIllness selectById(String id) {
        return selectById(id);
    }

    @Override
    public List<AnamnesisIllness> selectByParams(AnamnesisIllness anamnesisIllness) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<AnamnesisIllness> findAll() {
        return anamnesisIllnessMapper.findAll();
    }

    @Override
    public List<AnamnesisIllness> selectByAnamnesisIllnessName(String anamnesisIllnessName) {
        System.out.println(anamnesisIllnessName);
        return anamnesisIllnessMapper.selectByAnamnesisIllnessName(anamnesisIllnessName);
    }
}
