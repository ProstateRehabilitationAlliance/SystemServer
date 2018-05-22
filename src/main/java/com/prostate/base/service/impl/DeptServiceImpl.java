package com.prostate.base.service.impl;

import com.prostate.base.domain.DeptDO;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.dao.DeptDao;
import com.prostate.base.service.DeptService;



@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	public DeptDO getByNumber(String deptNumber) {
		return deptDao.getByNumber(deptNumber);
	}

	@Override
	public DeptDO getByName(String deptName) {
		return deptDao.getByName(deptName);
	}

	@Override
	public DeptDO get(String id){
		return deptDao.get(id);
	}

	@Override
	public List<DeptDO> list(Map<String, Object> map){
		return deptDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return deptDao.count(map);
	}

	@Override
	public int save(DeptDO dept){
		return deptDao.save(dept);
	}

	@Override
	public int update(DeptDO dept){
		return deptDao.update(dept);
	}

	@Override
	public int remove(String id){
		return deptDao.remove(id);
	}

	@Override
	public int batchRemove(String[] ids){
		return deptDao.batchRemove(ids);
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> sysDepts = deptDao.list(new HashMap<String,Object>(16));

		for (DeptDO sysDept : sysDepts) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(sysDept.getId().toString());
			tree.setParentId(sysDept.getParentDeptId().toString());
			tree.setText(sysDept.getDeptName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}
//
//	@Override
//	public List<DeptDO> listByName(String name) {
//		return null;
//	}

}
