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


    List<Profession> findAll();

    List<Profession> selectByProfessionName(String professionName);
}