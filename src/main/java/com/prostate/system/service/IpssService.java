package com.prostate.system.service;

import com.prostate.system.entity.Ipss;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:17 2018/4/26
 */
public interface IpssService extends BaseService<Ipss> {

    public List<Ipss> findAll();

    public List<Ipss> findByParentId(String parentId);

}
