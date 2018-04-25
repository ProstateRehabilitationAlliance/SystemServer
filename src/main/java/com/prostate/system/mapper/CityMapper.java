package com.prostate.system.mapper;

import com.prostate.system.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> findByParentCityId(String parentCityId);


    public List<City> selectByCityName(String param);

    City selectByCityType(String cityTape);
}