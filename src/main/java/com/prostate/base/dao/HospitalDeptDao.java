package com.prostate.base.dao;

import com.prostate.base.domain.HospitalDeptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 医院科室表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface HospitalDeptDao {

	HospitalDeptDO get(String id);
	
	List<HospitalDeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HospitalDeptDO hospitalDept);
	
	int update(HospitalDeptDO hospitalDept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
