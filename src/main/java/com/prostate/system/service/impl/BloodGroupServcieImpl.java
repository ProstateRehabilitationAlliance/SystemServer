package com.prostate.system.service.impl;

import com.prostate.system.entity.BloodGroup;
import com.prostate.system.mapper.BloodGroupMapper;
import com.prostate.system.service.BloodGroupServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/26 11:23
 * @Todo: 血型服务接口的实现类
 */
@Transactional
@Service
public class BloodGroupServcieImpl implements BloodGroupServcie {

    @Autowired
    private BloodGroupMapper bloodGroupMapper;

    @Override
    public int insertSelective(BloodGroup bloodGroup) {
        return bloodGroupMapper.insertSelective(bloodGroup);
    }

    @Override
    public int updateSelective(BloodGroup bloodGroup) {
        return bloodGroupMapper.updateSelective(bloodGroup);
    }

    @Override
    public BloodGroup selectById(String id) {
        return bloodGroupMapper.selectById(id);
    }

    @Override
    public List<BloodGroup> selectAll() {
        return bloodGroupMapper.selectAll();
    }

    @Override
    public List<BloodGroup> selectByName(String bloodGroupName) {
        return bloodGroupMapper.selectByName(bloodGroupName);
    }

    @Override
    public List<BloodGroup> selectByNumber(String bloodGroupNumber) {
        return bloodGroupMapper.selectByNumber(bloodGroupNumber);
    }

    @Override
    public List<BloodGroup> selectByParams(BloodGroup bloodGroup) {
       // System.out.println(">>>>>>>>>"+bloodGroupMapper.selectByParams(bloodGroup));
        return bloodGroupMapper.selectByParams(bloodGroup);
    }

    @Override
    public int deleteById(String id) {
        return bloodGroupMapper.deleteById(id);
    }
}
