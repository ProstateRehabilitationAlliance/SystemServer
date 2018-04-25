package com.prostate.system.mapper;

import com.prostate.system.entity.Illness;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IllnessMapper {
    int deleteByPrimaryKey(String id);

    int insert(Illness record);

    int insertSelective(Illness record);

    Illness selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Illness record);

    int updateByPrimaryKey(Illness record);


    List<Illness> findAll();
    List<Illness> selectByIllnessName(String illnessName);

}