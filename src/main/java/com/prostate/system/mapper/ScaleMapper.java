package com.prostate.system.mapper;

import com.prostate.system.entity.Scale;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScaleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Scale record);

    int insertSelective(Scale record);

    Scale selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Scale record);

    int updateByPrimaryKey(Scale record);


    public List<Scale> list(String parentId);
}