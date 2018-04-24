package com.prostate.system.service.impl;

import com.prostate.system.entity.AnamnesisEatingDrug;
import com.prostate.system.mapper.AnamnesisEatingDrugMapper;
import com.prostate.system.service.AnamnesisEatingDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 17:50
 * @Todo:服务接口的实现类
 */

@Transactional
@Service
public class AnamnesisEatingDrugServiceImpl implements AnamnesisEatingDrugService{
    @Autowired
    private AnamnesisEatingDrugMapper anamnesisEatingDrugMapper;

    @Override
    public int insertSelective(AnamnesisEatingDrug anamnesisEatingDrug) {
        return anamnesisEatingDrugMapper.insertSelective(anamnesisEatingDrug);
    }

    @Override
    public int updateSelective(AnamnesisEatingDrug anamnesisEatingDrug) {
        return anamnesisEatingDrugMapper.updateByPrimaryKeySelective(anamnesisEatingDrug);
    }

    @Override
    public AnamnesisEatingDrug selectById(String id) {
        return anamnesisEatingDrugMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AnamnesisEatingDrug> selectAll() {
        return anamnesisEatingDrugMapper.selectAll();
    }

    @Override
    public List<AnamnesisEatingDrug> selectByName(String drugName) {
        return anamnesisEatingDrugMapper.selectByName(drugName);
    }

    @Override
    public List<AnamnesisEatingDrug> selectByParams(AnamnesisEatingDrug anamnesisEatingDrug) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return anamnesisEatingDrugMapper.deleteByPrimaryKey(id);
    }
}
