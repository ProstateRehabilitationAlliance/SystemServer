package com.prostate.system.service.impl;

import com.prostate.system.entity.Hospital;
import com.prostate.system.mapper.HospitalMapper;
import com.prostate.system.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 13:17
 * @Todo:  医院服务接口的实现类
 */
@Transactional
@Service
public class HospitalServiceImpl  implements HospitalService{

    @Autowired
    private HospitalMapper hospitalMapper;


    @Override
    public int insertSelective(Hospital hospital) {
        return hospitalMapper.insertSelective(hospital);
    }

    @Override
    public int updateSelective(Hospital hospital) {
        return hospitalMapper.updateByPrimaryKeySelective(hospital);
    }

    @Override
    public Hospital selectById(String id) {
        return hospitalMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Hospital> selectByParams(Hospital hospital) {
        return null;
    }

    @Override
    public List<Hospital> selectAll() {
        return hospitalMapper.selectAllHospital();
    }

    @Override
    public List<Hospital> selectByName(String hospitalName) {
        return hospitalMapper.selectByName(hospitalName);
    }

    @Override
    public int deleteById(String id) {
        return hospitalMapper.deleteByPrimaryKey(id);
    }
}
