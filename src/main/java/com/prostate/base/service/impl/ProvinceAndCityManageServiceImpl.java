package com.prostate.base.service.impl;

import com.prostate.base.dao.CityDao;
import com.prostate.base.domain.CityDO;
import com.prostate.base.service.ProvinceAndCityManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:20 2018/5/14
 */
@Service
public class ProvinceAndCityManageServiceImpl implements ProvinceAndCityManageService{
    @Autowired
    private CityDao cityDao;
    @Override
    public CityDO get(String id) {
        return cityDao.get(id);
    }

    @Override
    public List<CityDO> list(Map<String, Object> map) {
        return cityDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return cityDao.count(map);
    }

    @Override
    public int save(CityDO cityDO) {
        return cityDao.save(cityDO);
    }

    @Override
    public int update(CityDO cityDO) {
        return cityDao.update(cityDO);
    }

    @Override
    public int remove(String id) {
        return cityDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) {
        return 0;
    }

    @Override
    public List<CityDO> listByName(String name) {
        return null;
    }

    @Override
    public List<CityDO> listByNumber(String number) {
        return null;
    }
}
