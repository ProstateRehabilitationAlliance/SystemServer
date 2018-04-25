package com.prostate.system.service.impl;

import com.prostate.system.entity.NihCpsi;
import com.prostate.system.mapper.NihCpsiMapper;
import com.prostate.system.service.NihCpsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 17:39 2018/4/25
 */
@Service
public class NihCpsiServiceImpl  implements NihCpsiService{
    @Autowired
    private NihCpsiMapper nihCpsiMapper;
    @Override
    public List<NihCpsi> findAll() {
        return nihCpsiMapper.findAll();
    }

    @Override
    public List<NihCpsi> findByParentId(String parentId) {
        return nihCpsiMapper.findByParentId(parentId);
    }

    @Override
    public int insertSelective(NihCpsi nihCpsi) {
        return nihCpsiMapper.insertSelective(nihCpsi);
    }

    @Override
    public int updateSelective(NihCpsi nihCpsi) {
        return nihCpsiMapper.updateByPrimaryKeySelective(nihCpsi);
    }

    @Override
    public NihCpsi selectById(String id) {
        return nihCpsiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NihCpsi> selectByParams(NihCpsi nihCpsi) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
