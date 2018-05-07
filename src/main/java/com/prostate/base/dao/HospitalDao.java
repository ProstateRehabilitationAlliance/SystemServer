package com.prostate.base.dao;

import com.prostate.base.domain.HospitalDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 医院表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface HospitalDao {

	HospitalDO get(String id);
	
	List<HospitalDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HospitalDO hospital);
	
	int update(HospitalDO hospital);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
