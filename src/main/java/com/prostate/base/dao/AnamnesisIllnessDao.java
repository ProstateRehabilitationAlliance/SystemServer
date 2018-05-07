package com.prostate.base.dao;

import com.prostate.base.domain.AnamnesisIllnessDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface AnamnesisIllnessDao {

	AnamnesisIllnessDO get(String id);
	
	List<AnamnesisIllnessDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AnamnesisIllnessDO anamnesisIllness);
	
	int update(AnamnesisIllnessDO anamnesisIllness);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
