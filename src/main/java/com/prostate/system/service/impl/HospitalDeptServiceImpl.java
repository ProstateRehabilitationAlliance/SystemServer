package com.prostate.system.service.impl;

import com.prostate.system.entity.HospitalDept;
import com.prostate.system.mapper.HospitalDeptMapper;
import com.prostate.system.service.HospitalDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 17:35
 * @Todo:
 */

@Transactional
@Service
public class HospitalDeptServiceImpl implements HospitalDeptService {

    @Autowired
    private HospitalDeptMapper hospitalDeptMapper;

    @Override
    public int insertSelective(HospitalDept hospitalDept) {
        return hospitalDeptMapper.insertSelective(hospitalDept);
    }

    @Override
    public int updateSelective(HospitalDept hospitalDept) {
        return hospitalDeptMapper.updateByPrimaryKeySelective(hospitalDept);
    }

    @Override
    public HospitalDept selectById(String id) {
        return hospitalDeptMapper.selectByID(id);
    }

    //这个方法暂时不用
    @Override
    public List<HospitalDept> selectByParams(HospitalDept hospitalDept) {
        return null;
    }

    @Override
    public List<HospitalDept> selectAll() {
        return hospitalDeptMapper.selectAllHospitalDept();
    }

    @Override
    public List<HospitalDept> selectByHospitalIDAndDeptID(String hospitalId, String deptId) {
        return hospitalDeptMapper.selectByHospitalIDAndDeptID(hospitalId, deptId);
    }

    @Override
    public int deleteById(String id) {
        return hospitalDeptMapper.deleteByPrimaryKey(id);
    }
}
