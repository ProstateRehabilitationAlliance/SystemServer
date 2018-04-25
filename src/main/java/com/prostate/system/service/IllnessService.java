package com.prostate.system.service;

import com.prostate.system.entity.Illness;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:52 2018/4/25
 */
public interface IllnessService extends BaseService<Illness> {
    List<Illness> findAll();
    List<Illness> selectByIllnessName(String illnessName);

}
