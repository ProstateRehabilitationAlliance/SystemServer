package com.prostate.base.dao;

import com.prostate.base.domain.ScaleDO;

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
public interface ScaleDao {

	ScaleDO get(String id);
	
	List<ScaleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScaleDO scale);
	
	int update(ScaleDO scale);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
