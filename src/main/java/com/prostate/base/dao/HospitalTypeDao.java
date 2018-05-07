package com.prostate.base.dao;

import com.prostate.base.domain.HospitalTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 医院类型表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface HospitalTypeDao {

	HospitalTypeDO get(String id);
	
	List<HospitalTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HospitalTypeDO hospitalType);
	
	int update(HospitalTypeDO hospitalType);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
