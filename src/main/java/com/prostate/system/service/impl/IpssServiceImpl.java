package com.prostate.system.service.impl;

import com.prostate.system.entity.Ipss;
import com.prostate.system.mapper.IpssMapper;
import com.prostate.system.service.IpssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:18 2018/4/26
 */
@Service
public class IpssServiceImpl implements IpssService {
    @Autowired
    private IpssMapper ipssMapper;
    @Override
    public List<Ipss> findAll() {
        return ipssMapper.findAll();
    }

    @Override
    public List<Ipss> findByParentId(String parentId) {
        return ipssMapper.findByParentId(parentId);
    }

    @Override
    public int insertSelective(Ipss ipss) {
        return ipssMapper.insertSelective(ipss);
    }

    @Override
    public int updateSelective(Ipss ipss) {
        return ipssMapper.updateByPrimaryKeySelective(ipss);
    }

    @Override
    public Ipss selectById(String id) {
        return ipssMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ipss> selectByParams(Ipss ipss) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
