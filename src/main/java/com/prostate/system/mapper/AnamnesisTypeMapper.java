package com.prostate.system.mapper;

import com.prostate.system.entity.AnamnesisType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnamnesisTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(AnamnesisType record);

    int insertSelective(AnamnesisType record);

    AnamnesisType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AnamnesisType record);

    int updateByPrimaryKey(AnamnesisType record);

    public List<AnamnesisType> selectByAnamnesisTypeName(String anamnesisTypeName);


    List<AnamnesisType> findAll();


}