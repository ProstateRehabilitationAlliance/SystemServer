package com.prostate.base.dao;

import com.prostate.base.domain.EducationDO;

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
public interface EducationDao {

	EducationDO get(String id);
	
	List<EducationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EducationDO education);
	
	int update(EducationDO education);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
