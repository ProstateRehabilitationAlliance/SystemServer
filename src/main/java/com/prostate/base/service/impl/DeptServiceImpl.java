package com.prostate.base.service.impl;

import com.prostate.base.dao.read.DeptReadMapper;
import com.prostate.base.dao.write.DeptWriteMapper;
import com.prostate.base.domain.DeptDO;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.service.DeptService;



@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptWriteMapper deptWriteMapper;

	@Autowired
	private DeptReadMapper deptReadMapper;

	@Override
	public DeptDO getByNumber(String deptNumber) {
		return deptReadMapper.getByNumber(deptNumber);
	}

	@Override
	public DeptDO getByName(String deptName) {
		return deptReadMapper.getByName(deptName);
	}

	@Override
	public DeptDO get(String id){
		return deptReadMapper.get(id);
	}

	@Override
	public List<DeptDO> list(Map<String, Object> map){
		return deptReadMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return deptReadMapper.count(map);
	}

	@Override
	public int save(DeptDO dept){
		return deptWriteMapper.save(dept);
	}

	@Override
	public int update(DeptDO dept){
		return deptWriteMapper.update(dept);
	}

	@Override
	public int remove(String id){
		return deptWriteMapper.remove(id);
	}

	@Override
	public int batchRemove(String[] ids){
		return deptWriteMapper.batchRemove(ids);
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> sysDepts = deptReadMapper.list(new HashMap<String,Object>(16));

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
