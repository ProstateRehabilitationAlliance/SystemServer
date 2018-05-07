package com.prostate.base.dao;

import com.prostate.base.domain.DoctorTitleDO;

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
public interface DoctorTitleDao {

	DoctorTitleDO get(String id);
	
	List<DoctorTitleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DoctorTitleDO doctorTitle);
	
	int update(DoctorTitleDO doctorTitle);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
