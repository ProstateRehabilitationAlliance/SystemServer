package com.prostate.system.mapper;

import com.prostate.system.entity.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalMapper {
    // 根据ID删除
    int deleteByPrimaryKey(String id);

    // 插入数据
    int insert(Hospital hospital);

    // 选择性的插入
    int insertSelective(Hospital hospital);

    // 根据id查询
    Hospital selectByPrimaryKey(String id);

    // 查询所有的信息
    List<Hospital> selectAllHospital();
    // 根据名称查询信息
    List<Hospital>  selectByName(String hospitalName);

    // 选择性修改
    int updateByPrimaryKeySelective(Hospital hospital);

    //修改
    int updateByPrimaryKey(Hospital hospital);
}