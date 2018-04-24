package com.prostate.system.mapper;

import com.prostate.system.entity.Nation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationMapper extends BaseMapper<Nation>{


    int deleteByPrimaryKey(String id);

    int insert(Nation nation);

    int insertSelective(Nation nation);

    Nation selectById(String id);

    List<Nation> selectByNationName(String nationName);

    List<Nation> queryAllNation();

    int updateByPrimaryKeySelective(Nation nation);

    int updateByPrimaryKey(Nation nation);
}