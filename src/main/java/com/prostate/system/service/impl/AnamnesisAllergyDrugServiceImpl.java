package com.prostate.system.service.impl;

import com.prostate.system.entity.AnamnesisAllergyDrug;
import com.prostate.system.mapper.AnamnesisAllergyDrugMapper;
import com.prostate.system.service.AnamnesisAllergyDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 9:08
 * @Todo:  过敏药品的服务接口实现类
 */
@Transactional
@Service
public class AnamnesisAllergyDrugServiceImpl  implements AnamnesisAllergyDrugService {



    @Autowired
    private AnamnesisAllergyDrugMapper anamnesisAllergyDrugMapper;


    @Override
    public List<AnamnesisAllergyDrug> selectByParams(AnamnesisAllergyDrug anamnesisAllergyDrug) {
        return null;
    }

    @Override
    public int insertSelective(AnamnesisAllergyDrug anamnesisAllergyDrug) {
        return anamnesisAllergyDrugMapper.insertSelective(anamnesisAllergyDrug);
    }

    @Override
    public int updateSelective(AnamnesisAllergyDrug anamnesisAllergyDrug) {
        return anamnesisAllergyDrugMapper.updateByPrimaryKeySelective(anamnesisAllergyDrug);
    }

    @Override
    public AnamnesisAllergyDrug selectById(String id) {
        return anamnesisAllergyDrugMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AnamnesisAllergyDrug> selectAll() {
        return anamnesisAllergyDrugMapper.selectAllAnamnesisAllergyDrug();
    }

    @Override
    public List<AnamnesisAllergyDrug> selectByName(String drugName) {
        return anamnesisAllergyDrugMapper.selectAnamnesisAllergyDrugByName(drugName);
    }

    @Override
    public int deleteById(String id) {
        return anamnesisAllergyDrugMapper.deleteByPrimaryKey(id);
    }


}
