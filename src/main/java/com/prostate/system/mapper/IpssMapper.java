package com.prostate.system.mapper;

import com.prostate.system.entity.Ipss;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IpssMapper {
    int deleteByPrimaryKey(String id);

    int insert(Ipss record);

    int insertSelective(Ipss record);

    Ipss selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Ipss record);

    int updateByPrimaryKey(Ipss record);


    public List<Ipss> findAll();

    public List<Ipss> findByParentId(String parentId);
}