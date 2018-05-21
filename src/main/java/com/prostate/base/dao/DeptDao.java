package com.prostate.base.dao;

import java.util.List;
import java.util.Map;

import com.prostate.base.domain.DeptDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 科室表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface DeptDao {

	DeptDO get(String id);

	DeptDO getByNumber(String deptNumber);

	DeptDO getByName(String deptName);

	List<DeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<DeptDO> listByName(String name);


	List<DeptDO> getTree(Map<String, Object> map);
}
