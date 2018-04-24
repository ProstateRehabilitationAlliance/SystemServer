package com.prostate.system.mapper;

import com.prostate.system.entity.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
    //查询学历列表
    public List<Profession> findAll();

      Profession findByProfessionName(String professionName);
}