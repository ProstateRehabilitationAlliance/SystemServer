package com.prostate.base.service.impl;

import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.dao.DeptDao;
import com.prostate.base.domain.DeptDO;
import com.prostate.base.service.DeptService;



@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	
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
		List<DeptDO> cityDOS = deptDao.getTree(new HashMap<String, Object>(16));
		for (DeptDO cityDO:cityDOS){
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(cityDO.getId());
			tree.setParentId(cityDO.getParentDeptId());
			tree.setText(cityDO.getDeptName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			state.put("selected_arr",false);

			//state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);



		}
		Tree<DeptDO> t = BuildTree.build(trees);
		return t;
	}
//
//	@Override
//	public List<DeptDO> listByName(String name) {
//		return null;
//	}

}
