package com.prostate.system.service;

import com.prostate.system.entity.BloodGroup;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/26 11:18
 * @Todo: 血型管理的服务接口
 */

public interface BloodGroupServcie extends  BaseService<BloodGroup>{

    // 插入数据
    int insertSelective(BloodGroup e);

    //修改数据
    int updateSelective(BloodGroup e);

    // 根据id查找数据
    BloodGroup selectById(String id);

    // 根据名字
    List<BloodGroup> selectByName(String bloodGroupName);

    //  根据编号
    List<BloodGroup> selectByNumber(String bloodGroupNumber);

    // 删除
    int deleteById(String id);

    // 无参查询所有
    List<BloodGroup> selectAll();

}
