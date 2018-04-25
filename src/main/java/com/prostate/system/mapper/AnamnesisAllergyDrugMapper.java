package com.prostate.system.mapper;

import com.prostate.system.entity.AnamnesisAllergyDrug;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 9:12
 * @todo: 药品管理的mapper接口
 * @param:   * @param null
 */
@Repository
public interface AnamnesisAllergyDrugMapper {

    // 根据ID删除
    int deleteByPrimaryKey(String id);

    // 插入数据
    int insert(AnamnesisAllergyDrug record);

    // 选择性的插入
    int insertSelective(AnamnesisAllergyDrug record);

    // 根据id查询
    AnamnesisAllergyDrug selectByPrimaryKey(String id);

    // 查询所有的药品信息
    List<AnamnesisAllergyDrug>  selectAllAnamnesisAllergyDrug();

    // 药品名称查询药品信息
    List<AnamnesisAllergyDrug>  selectAnamnesisAllergyDrugByName(String drugName);

    // 选择性修改
    int updateByPrimaryKeySelective(AnamnesisAllergyDrug record);

    //修改
    int updateByPrimaryKey(AnamnesisAllergyDrug record);
}