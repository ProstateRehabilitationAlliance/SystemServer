package com.prostate.base.service.impl;

import com.prostate.base.domain.UrineRoutineDO;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

import com.prostate.base.dao.UrineRoutineDao;
import com.prostate.base.service.UrineRoutineService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UrineRoutineServiceImpl implements UrineRoutineService {

	@Autowired
	private UrineRoutineDao urineRoutineDao;

	@Override
	public UrineRoutineDO get(String id) {
		return urineRoutineDao.get(id);
	}

	@Override
	public List<UrineRoutineDO> list(Map<String, Object> map) {
		return urineRoutineDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int save(UrineRoutineDO urineRoutineDO) {
		return urineRoutineDao.save(urineRoutineDO);
	}

	@Override
	public int update(UrineRoutineDO urineRoutineDO) {
		return urineRoutineDao.update(urineRoutineDO);
	}

	@Override
	public int remove(String id) {
		return 0;
	}

	@Override
	public int batchRemove(String[] ids) {
		return 0;
	}

	@Override
	public String[] listParentId() {
		return new String[0];
	}

	@Override
	public int getDeptUserNumber(String id) {
		return 0;
	}

	@Override
	public Tree<UrineRoutineDO> getTree() {
		List<Tree<UrineRoutineDO>> trees = new ArrayList<Tree<UrineRoutineDO>>();
		List<UrineRoutineDO> urineRoutineDOS = urineRoutineDao.getTree(new HashMap<String,Object>(16));

		for (UrineRoutineDO urineRoutineDO : urineRoutineDOS) {
			Tree<UrineRoutineDO> tree = new Tree<UrineRoutineDO>();
			tree.setId(urineRoutineDO.getId().toString());
			if (urineRoutineDO.getParentId()==null||urineRoutineDO.getParentId().equals("")){

			}else {
				tree.setParentId(urineRoutineDO.getParentId().toString());
			}

			tree.setText(urineRoutineDO.getScaleTitle());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<UrineRoutineDO> t = BuildTree.build(trees);
		return t;
	}
}
