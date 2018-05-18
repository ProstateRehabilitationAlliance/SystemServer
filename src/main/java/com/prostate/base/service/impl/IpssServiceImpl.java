package com.prostate.base.service.impl;

import com.prostate.base.dao.IpssManagerDao;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.domain.IpssDO;
import com.prostate.base.service.IpssManagerService;



@Service
public class IpssServiceImpl implements IpssManagerService {
	@Autowired
	private IpssManagerDao ipssManagerDao;
	
	@Override
	public IpssDO get(String id){
		return ipssManagerDao.get(id);
	}
	
	@Override
	public List<IpssDO> list(Map<String, Object> map){
		return ipssManagerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ipssManagerDao.count(map);
	}
	
	@Override
	public int save(IpssDO ipss){
		return ipssManagerDao.save(ipss);
	}
	
	@Override
	public int update(IpssDO ipss){
		return ipssManagerDao.update(ipss);
	}
	
	@Override
	public int remove(String id){
		return ipssManagerDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return ipssManagerDao.batchRemove(ids);
	}


	@Override
	public Tree<IpssDO> getTree() {
		List<Tree<IpssDO>> trees = new ArrayList<Tree<IpssDO>>();
		List<IpssDO> ipssDOS = ipssManagerDao.getTree(new HashMap<String, Object>(16));
		for (IpssDO ipssDO:ipssDOS){
			Tree<IpssDO> tree = new Tree<IpssDO>();
			tree.setId(ipssDO.getId());
			tree.setParentId(ipssDO.getParentId());
			tree.setText(ipssDO.getIpssTitle());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			state.put("selected_arr",false);

			//state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);



		}
		System.out.println("========>"+trees);
		Tree<IpssDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public List<IpssDO> listByName(String name) {
		return ipssManagerDao.listByName(name);
	}
	
}
