package com.prostate.base.mapper.read;

import com.prostate.base.domain.HospitalTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 医院类型表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface HospitalTypeReadMapper {

	HospitalTypeDO get(String id);
	
	List<HospitalTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HospitalTypeDO hospitalType);
	
	int update(HospitalTypeDO hospitalType);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<HospitalTypeDO> listByName(String name);

	List<HospitalTypeDO> listByNumber(String number);
}
