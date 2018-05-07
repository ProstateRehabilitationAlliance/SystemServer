package com.prostate.base.dao;

import com.prostate.base.domain.ProfessionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:36
 */
@Mapper
public interface ProfessionDao {

	ProfessionDO get(String id);
	
	List<ProfessionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProfessionDO profession);
	
	int update(ProfessionDO profession);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
