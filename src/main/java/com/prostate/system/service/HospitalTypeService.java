package com.prostate.system.service;

import com.prostate.system.entity.HospitalType;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 14:45
 * @Todo:医院类型管理的服务接口
 */

public interface HospitalTypeService extends  BaseService<HospitalType> {

    //选择性的插入数据
    int insertSelective(HospitalType hospitalType);

    //选择性修改
    int updateSelective(HospitalType hospitalType);

    //根据id查询信息
    HospitalType selectById(String id);

    // 无参查询信息列表
    List<HospitalType> selectAll();

    // 根据名称查询
    List<HospitalType> selectByName(String hospitalTypeName);

    // 根据id删除
    int deleteById(String id);
}
