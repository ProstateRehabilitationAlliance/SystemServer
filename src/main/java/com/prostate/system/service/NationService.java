package com.prostate.system.service;

import com.prostate.system.entity.Nation;


import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 13:40
 * @Todo:
 */

public interface NationService extends BaseService<Nation> {

    int insertSelective(Nation nation);

    int updateSelective(Nation nation);

    Nation selectById(String id);
    //增加无参方法,主要是为了无参查询
    List<Nation> queryAllNation();

    List<Nation> selectByNationName(String nationName);

    int deleteById(String id);
}
