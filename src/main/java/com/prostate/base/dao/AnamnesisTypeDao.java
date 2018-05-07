package com.prostate.base.dao;

import com.prostate.base.domain.AnamnesisTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author xiaobai
 * @email 1992lcg@163.com
 * @date 2018-05-04 14:46:36
 */
@Mapper
public interface AnamnesisTypeDao {

	AnamnesisTypeDO get(String id);
	
	List<AnamnesisTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AnamnesisTypeDO anamnesisType);
	
	int update(AnamnesisTypeDO anamnesisType);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
