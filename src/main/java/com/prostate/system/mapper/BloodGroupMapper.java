package com.prostate.system.mapper;

import com.prostate.system.entity.BloodGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodGroupMapper extends BaseMapper<BloodGroup>{



    //  插入数据
    int insertSelective(BloodGroup e);

    // 修改数据
    int updateSelective(BloodGroup e);

    //根据id查询数据
    BloodGroup selectById(String id);

    // 根据部分参数查询信息
    List<BloodGroup> selectByParams(BloodGroup bloodGroup);


    //  根据血型名称
    List<BloodGroup> selectByName(String bloodGroupName);

    //  根据血型名称
    List<BloodGroup> selectByNumber(String bloodGroupNumber);

    // 根据ID删除
    int deleteById(String id);

    // 无参查询所有
    List<BloodGroup> selectAll();
}