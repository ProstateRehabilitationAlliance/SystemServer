package com.prostate.base.dao;

import com.prostate.base.domain.CityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 城市表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Repository
public interface CityDao {

	CityDO get(String id);
	
	List<CityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CityDO city);
	
	int update(CityDO city);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
