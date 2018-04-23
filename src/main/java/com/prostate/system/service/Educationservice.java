package com.prostate.system.service;

import com.prostate.system.entity.Education;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/4/23 14:42
 * @Todo: 教育背景的接口
 */

public interface Educationservice extends BaseService<Education>{

    //添加学历
    int insertSelective(Education e);

    //修改学历
    int updateSelective(Education e);

    //根据ID查询学历信息
    Education selectById(String id);

    //返回学历列表
    List<Education> selectByParams();
    //删除学历信息
    int deleteById(String id);

    //根据学历名称查询学历
    List<Education> selectByName(String educationName);

}
