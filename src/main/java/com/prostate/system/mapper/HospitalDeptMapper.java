package com.prostate.system.mapper;

import com.prostate.system.entity.HospitalDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDeptMapper {
    // 根据ID删除
    int deleteByPrimaryKey(String id);

    // 插入数据
    int insert(HospitalDept hospitalDept);

    // 选择性的插入
    int insertSelective(HospitalDept hospitalDept);

    // 根据id查询
    HospitalDept selectByID(String id);

    // 查询所有的信息
    List<HospitalDept> selectAllHospitalDept();

    // 选择性修改
    int updateByPrimaryKeySelective(HospitalDept hospitalDept);

    // 根据医院id和科室id查询
    List<HospitalDept> selectByHospitalIDAndDeptID(@Param("hospitalId") String hospitalId, @Param("deptId")String deptId);

    // 修改
    int updateByPrimaryKey(HospitalDept hospitalDept);
}