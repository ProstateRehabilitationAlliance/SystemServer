package com.prostate.system.service;

import com.prostate.system.entity.Hospital;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 13:12
 * @Todo:医院管理控制器
 */

public interface HospitalService extends BaseService<Hospital>{

    //选择性的插入数据
    int insertSelective(Hospital hospital);

    //选择性修改
    int updateSelective(Hospital hospital);

    //根据id查询信息
    Hospital selectById(String id);

    // 无参查询信息列表
    List<Hospital> selectAll();

    // 根据名称查询
    List<Hospital> selectByName(String hospitalName);

    // 根据id删除
    int deleteById(String id);

}
