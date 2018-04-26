package com.prostate.system.service;

import com.prostate.system.entity.HospitalDept;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 17:32
 * @Todo:科室信息管理服务
 */

public interface HospitalDeptService extends  BaseService<HospitalDept> {
    //选择性的插入数据
    int insertSelective(HospitalDept hospitalDept);

    //选择性修改
    int updateSelective(HospitalDept hospitalDept);

    //根据id查询信息
    HospitalDept selectById(String id);

    // 无参查询信息列表
    List<HospitalDept> selectAll();

    // 根据医院ID和科室ID共同查询数据,确保插入数据的唯一性
    List<HospitalDept> selectByHospitalIDAndDeptID(String hospitalId,String DeptId);


    // 根据id删除
    int deleteById(String id);
}
