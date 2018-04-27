package com.prostate.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.AnamnesisType;
import com.prostate.system.mapper.AnamnesisTypeMapper;
import com.prostate.system.service.AnamnesisTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 16:17 2018/4/24
 */
@Service
public class AnamnesisTypeServiceImpl  implements AnamnesisTypeService{

    @Autowired
    private AnamnesisTypeMapper anamnesisTypeMapper;

    @Override
    public int insertSelective(AnamnesisType anamnesisType) {
        return anamnesisTypeMapper.insertSelective(anamnesisType);
    }

    @Override
    public int updateSelective(AnamnesisType anamnesisType) {
        return anamnesisTypeMapper.updateByPrimaryKeySelective(anamnesisType);
    }

    @Override
    public AnamnesisType selectById(String id) {
        return anamnesisTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AnamnesisType> selectByParams(AnamnesisType anamnesisType) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<AnamnesisType> findAll(int page,int rows) {
        PageHelper.startPage(page,rows);
        System.out.println();
        return anamnesisTypeMapper.findAll();
    }

    @Override
    public List<AnamnesisType> selectByAnamnesisTypeName(String anamnesisTypeName) {
        return anamnesisTypeMapper.selectByAnamnesisTypeName(anamnesisTypeName);
    }
}
