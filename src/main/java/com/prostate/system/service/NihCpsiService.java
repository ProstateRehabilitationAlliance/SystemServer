package com.prostate.system.service;

import com.prostate.system.entity.NihCpsi;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 17:39 2018/4/25
 */
public interface NihCpsiService extends BaseService<NihCpsi>{

    public List<NihCpsi> findAll();

    public List<NihCpsi> findByParentId(String parentId);

    //List<NihCpsi> selectByCityName(String param);
}
