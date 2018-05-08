package com.prostate.base.dao;

import com.prostate.base.domain.BloodGroupDO;

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
public interface BloodGroupDao {

	BloodGroupDO get(String id);

	BloodGroupDO getByName(String bloodGroupName);

	BloodGroupDO getByNumBer(String bloodGroupNumber);

	List<BloodGroupDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BloodGroupDO bloodGroup);

	int update(BloodGroupDO bloodGroup);


	int remove(String id);
	
	int batchRemove(String[] ids);
}
