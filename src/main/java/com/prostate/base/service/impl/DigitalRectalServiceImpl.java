package com.prostate.base.service.impl;

import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.dao.DigitalRectalDao;
import com.prostate.base.domain.DigitalRectalDO;
import com.prostate.base.service.DigitalRectalService;



@Service
public class DigitalRectalServiceImpl implements DigitalRectalService {
	@Autowired
	private DigitalRectalDao digitalRectalDao;
	
	@Override
	public DigitalRectalDO get(String id){
		return digitalRectalDao.get(id);
	}
	
	@Override
	public List<DigitalRectalDO> list(Map<String, Object> map){
		return digitalRectalDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return digitalRectalDao.count(map);
	}
	
	@Override
	public int save(DigitalRectalDO digitalRectal){
		return digitalRectalDao.save(digitalRectal);
	}
	
	@Override
	public int update(DigitalRectalDO digitalRectal){
		return digitalRectalDao.update(digitalRectal);
	}
	
	@Override
	public int remove(String id){
		return digitalRectalDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return digitalRectalDao.batchRemove(ids);
	}

	@Override
	public Tree<DigitalRectalDO> getTree() {
		List<Tree<DigitalRectalDO>> trees = new ArrayList<Tree<DigitalRectalDO>>();
		List<DigitalRectalDO> digitalRectalDOS = digitalRectalDao.list(new HashMap<String,Object>(16));
		for (DigitalRectalDO digitalRectalDO : digitalRectalDOS) {
			Tree<DigitalRectalDO> tree = new Tree<DigitalRectalDO>();
			tree.setId(digitalRectalDO.getId().toString());
			tree.setParentId(digitalRectalDO.getParentId().toString());
			tree.setText(digitalRectalDO.getScaleTitle());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DigitalRectalDO> t = BuildTree.build(trees);
		return t;
	}

}