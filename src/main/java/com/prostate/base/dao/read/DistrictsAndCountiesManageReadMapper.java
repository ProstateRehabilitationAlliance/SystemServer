package com.prostate.base.dao.read;

import com.prostate.base.domain.CityDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 11:29 2018/5/14
 */
public interface DistrictsAndCountiesManageReadMapper {

    CityDO get(String id);

    List<CityDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CityDO city);

    int update(CityDO city);

    int remove(String id);

    int batchRemove(String[] ids);

    List<CityDO> listByName(String name);

    List<CityDO> listByNumber(String number);

    public List<CityDO> getTree(Map<String, Object> map);
}
