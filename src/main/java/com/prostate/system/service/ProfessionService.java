package com.prostate.system.service;

import com.prostate.system.entity.Profession;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 13:18 2018/4/24
 */
public interface ProfessionService extends BaseService<Profession>{

    List<Profession> findAll();

    Profession findByProfessionName(String profession);
}
