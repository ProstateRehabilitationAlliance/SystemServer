package com.prostate.system.mapper;

import com.prostate.system.entity.AnamnesisEatingDrug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnamnesisEatingDrugMapper extends BaseMapper<AnamnesisEatingDrug>{

    int deleteByPrimaryKey(String id);

    int insert(AnamnesisEatingDrug record);

    int insertSelective(AnamnesisEatingDrug record);

    AnamnesisEatingDrug selectByPrimaryKey(String id);


    List<AnamnesisEatingDrug> selectAll();
    //按照名字查询
    List<AnamnesisEatingDrug> selectByName(String drugName);

    int updateByPrimaryKeySelective(AnamnesisEatingDrug record);

    int updateByPrimaryKey(AnamnesisEatingDrug record);
}