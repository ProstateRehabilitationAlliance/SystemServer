package com.prostate.system.service;

import com.prostate.system.entity.AnamnesisAllergyDrug;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 9:04
 * @Todo:  过敏药品的服务接口
 */

public interface AnamnesisAllergyDrugService  extends BaseService<AnamnesisAllergyDrug>{

    //选择性的插入数据
    int insertSelective(AnamnesisAllergyDrug anamnesisAllergyDrug);

    //选择性修改
    int updateSelective(AnamnesisAllergyDrug anamnesisAllergyDrug);

    //根据id查询信息
    AnamnesisAllergyDrug selectById(String id);

    // 无参查询信息列表
    List<AnamnesisAllergyDrug> selectAll(int pageNumber,int pageSize);

    // 根据名称查询
    List<AnamnesisAllergyDrug> selectByName(String drugName);

    // 根据id删除
    int deleteById(String id);
}
