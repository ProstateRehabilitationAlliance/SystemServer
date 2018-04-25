package com.prostate.system.service;

import com.prostate.system.entity.City;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 14:26 2018/4/23
 */
public interface CityService extends BaseService<City>{

    public List<City> findByPage(Integer pageNum,Integer pageSize,String parentCityId);


    List<City> selectByCityName(String param);

    City selectByCityType(String cityTape);
}
