package com.prostate.system.mapper;

import com.prostate.system.entity.Education;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationMapper {


    //根据id删除
    int deleteByPrimaryKey(String id);

    //新增学历信息
    int insert(Education record);
    //选择性的插入学历信息
    int insertSelective(Education record);

    //根据id查询学历信息
    Education selectByPrimaryKey(String id);

    //返回所有学历信息
    List<Education> selectAllEducation();

    //选择性修改学历信息
    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);
   //根据名称获取学历信息
   List<Education> selectByeducationName(String eduacationName);

}