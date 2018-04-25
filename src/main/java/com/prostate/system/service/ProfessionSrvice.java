package com.prostate.system.service;

import com.prostate.system.entity.Profession;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 9:49 2018/4/25
 */
public interface ProfessionSrvice extends BaseService<Profession>{

    List<Profession> findAll();
    List<Profession> selectByProfessionName(String professionName);
}
