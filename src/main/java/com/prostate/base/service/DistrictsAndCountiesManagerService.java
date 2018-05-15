package com.prostate.base.service;

import com.prostate.base.domain.CityDO;
import com.prostate.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:45 2018/5/14
 */
public interface DistrictsAndCountiesManagerService {

    CityDO get(String id);

    List<CityDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CityDO city);

    int update(CityDO city);

    int remove(String id);

    int batchRemove(String[] ids);

    Tree<CityDO> getTree();

    List<CityDO> listByName(String name);


}
