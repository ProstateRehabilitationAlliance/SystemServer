package com.prostate.system.mapper;

import com.prostate.system.entity.HospitalType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalTypeMapper {
    // 根据ID删除
    int deleteByPrimaryKey(String id);

    // 插入数据
    int insert(HospitalType hospitalType);

    // 选择性的插入
    int insertSelective(HospitalType hospitalType);

    // 根据id查询
    HospitalType selectByPrimaryKey(String id);

    // 查询所有的信息
    List<HospitalType> selectAllHospital();
    // 根据名称查询信息
    List<HospitalType>  selectByName(String hospitalTypeName);

    // 选择性修改
    int updateByPrimaryKeySelective(HospitalType hospitalType);

    //修改
    int updateByPrimaryKey(HospitalType hospitalType);
}