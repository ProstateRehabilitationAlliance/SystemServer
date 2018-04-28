package com.prostate.system.service;

import com.prostate.system.entity.Scale;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:26 2018/4/28
 */
public interface ScaleService extends BaseService<Scale>{

    public List<Scale> list(String parentId);

    //public List<Scale> findAll();
    List<Scale> selectByScaleName(String param);

    Scale selectByScale(String cityTape);
}
