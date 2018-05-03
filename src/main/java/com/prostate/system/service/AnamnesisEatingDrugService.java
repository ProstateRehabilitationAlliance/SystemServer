package com.prostate.system.service;

import com.prostate.system.entity.AnamnesisEatingDrug;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 17:42
 * @Todo:
 */

public interface AnamnesisEatingDrugService extends BaseService<AnamnesisEatingDrug> {

    //选择性的插入数据
    int insertSelective(AnamnesisEatingDrug anamnesisEatingDrug);

    //选择性修改
    int updateSelective(AnamnesisEatingDrug anamnesisEatingDrug);

    //根据id查询信息
    AnamnesisEatingDrug selectById(String id);

    //查询信息列表
    List<AnamnesisEatingDrug> selectAll(int pageNum,int pageSize);

    //根据名称查询
    List<AnamnesisEatingDrug> selectByName(String drugName);

    //删除
    int deleteById(String id);
}
