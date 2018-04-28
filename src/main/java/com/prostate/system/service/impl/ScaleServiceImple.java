package com.prostate.system.service.impl;

import com.prostate.system.entity.Scale;
import com.prostate.system.mapper.ScaleMapper;
import com.prostate.system.service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:30 2018/4/28
 */
@Service
public class ScaleServiceImple implements ScaleService {

    @Autowired
    private ScaleMapper scaleMapper;

    @Override
    public int insertSelective(Scale scale) {
        return scaleMapper.insertSelective(scale);
    }

    @Override
    public int updateSelective(Scale scale) {
        return scaleMapper.updateByPrimaryKeySelective(scale);
    }

    @Override
    public Scale selectById(String id) {
        return scaleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Scale> selectByParams(Scale scale) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<Scale> list(String parentId) {
        return scaleMapper.list(parentId);
    }

    @Override
    public List<Scale> selectByScaleName(String param) {
        return null;
    }

    @Override
    public Scale selectByScale(String cityTape) {
        return null;
    }
}
