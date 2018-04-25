package com.prostate.system.service.impl;

import com.prostate.system.entity.HospitalType;
import com.prostate.system.mapper.HospitalTypeMapper;
import com.prostate.system.service.HospitalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 14:47
 * @Todo:服务接口的实现类
 */
@Transactional
@Service
public class HospitalTypeServiceImpl implements HospitalTypeService{

    @Autowired
    private HospitalTypeMapper hospitalTypeMapper;

    @Override
    public int insertSelective(HospitalType hospitalType) {
        return hospitalTypeMapper.insertSelective(hospitalType);
    }

    @Override
    public int updateSelective(HospitalType hospitalType) {
        return hospitalTypeMapper.updateByPrimaryKeySelective(hospitalType);
    }

    @Override
    public HospitalType selectById(String id) {
        return hospitalTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HospitalType> selectAll() {
        return hospitalTypeMapper.selectAllHospital();
    }

    @Override
    public List<HospitalType> selectByName(String hospitalTypeName) {
        return hospitalTypeMapper.selectByName(hospitalTypeName);
    }

    @Override
    public int deleteById(String id) {
        return hospitalTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<HospitalType> selectByParams(HospitalType hospitalType) {
        return null;
    }
}
