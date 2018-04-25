package com.prostate.system.mapper;

import com.prostate.system.entity.NihCpsi;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NihCpsiMapper {
    int deleteByPrimaryKey(String id);

    int insert(NihCpsi record);

    int insertSelective(NihCpsi record);

    NihCpsi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NihCpsi record);

    int updateByPrimaryKey(NihCpsi record);

    public List<NihCpsi> findAll();

    public List<NihCpsi> findByParentId(String parentId);
}