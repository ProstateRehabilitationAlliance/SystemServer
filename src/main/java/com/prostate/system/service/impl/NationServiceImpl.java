package com.prostate.system.service.impl;

import com.prostate.system.entity.Nation;
import com.prostate.system.mapper.NationMapper;
import com.prostate.system.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 15:43
 * @Todo:
 */

@Transactional
@Service
public class NationServiceImpl implements NationService{
    @Autowired
    private NationMapper nationMapper;

    @Override
    public int insertSelective(Nation nation) {
        return nationMapper.insertSelective(nation);
    }

    @Override
    public int updateSelective(Nation nation) {
        return nationMapper.updateByPrimaryKeySelective(nation);
    }

    @Override
    public Nation selectById(String id) {
        return nationMapper.selectById(id);
    }

    @Override
    public List<Nation> selectByParams(Nation nation) {
        return null;
    }

    @Override
    public List<Nation> queryAllNation() {
        return nationMapper.queryAllNation();
    }

    @Override
    public List<Nation> selectByNationName(String nationName) {
        return nationMapper.selectByNationName(nationName);
    }

    @Override
    public int deleteById(String id) {
        return nationMapper.deleteByPrimaryKey(id);
    }
}
