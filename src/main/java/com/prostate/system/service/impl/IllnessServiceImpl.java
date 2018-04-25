package com.prostate.system.service.impl;

import com.prostate.system.entity.Illness;
import com.prostate.system.mapper.IllnessMapper;
import com.prostate.system.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:53 2018/4/25
 */
@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    private IllnessMapper illnessMapper;
    @Override
    public List<Illness> findAll() {
        return illnessMapper.findAll();
    }

    @Override
    public List<Illness> selectByIllnessName(String illnessName) {
        return illnessMapper.selectByIllnessName(illnessName);
    }

    @Override
    public int insertSelective(Illness illness) {
        return illnessMapper.insertSelective(illness);
    }

    @Override
    public int updateSelective(Illness illness) {
        return illnessMapper.updateByPrimaryKeySelective(illness);
    }

    @Override
    public Illness selectById(String id) {
        return illnessMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Illness> selectByParams(Illness illness) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
