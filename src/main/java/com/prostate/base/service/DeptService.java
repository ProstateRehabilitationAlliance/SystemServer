package com.prostate.base.service;

import com.prostate.base.domain.DeptDO;
import com.prostate.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 科室表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface DeptService {
	
	DeptDO get(String id);
	
	List<DeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	Tree<DeptDO> getTree();

//	List<DeptDO> listByName(String name);
}
