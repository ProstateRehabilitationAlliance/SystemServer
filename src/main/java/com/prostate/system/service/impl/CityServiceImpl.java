package com.prostate.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.City;
import com.prostate.system.mapper.CityMapper;
import com.prostate.system.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 14:26 2018/4/23
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public int insertSelective(City city) {
        return cityMapper.insertSelective(city);
    }

    @Override
    public int updateSelective(City city) {
        return cityMapper.updateByPrimaryKeySelective(city);
    }

    @Override
    public City selectById(String id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<City> selectByParams(City city) {
        return null;
    }

    @Override
    public int deleteById(String id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<City> findByPage(Integer pageNum, Integer pageSize, String parentCityId) {

        PageHelper.startPage(pageNum,pageSize);
        return cityMapper.findByParentCityId(parentCityId);
    }

    @Override
    public List<City> selectByCityName(String param) {


        return cityMapper.selectByCityName(param);
    }

    @Override
    public City selectByCityType(String cityTape) {
        return cityMapper.selectByCityType(cityTape);
    }
}
