package com.prostate.system.service.impl;

import com.prostate.system.entity.Profession;
import com.prostate.system.mapper.ProfessionMapper;
import com.prostate.system.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description: 学历服务
 * @Date: Created in 13:18 2018/4/24
 */
@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    @Override
    public int insertSelective(Profession profession) {
        return professionMapper.insertSelective(profession);
    }

    @Override
    public int updateSelective(Profession profession) {
        return professionMapper.updateByPrimaryKeySelective(profession);
    }

    @Override
    public Profession selectById(String id) {
        return professionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Profession> selectByParams(Profession profession) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<Profession> findAll() {

        return professionMapper.findAll();
    }

    @Override
    public Profession findByProfessionName(String profession) {
        return professionMapper.findByProfessionName(profession);
    }
}
