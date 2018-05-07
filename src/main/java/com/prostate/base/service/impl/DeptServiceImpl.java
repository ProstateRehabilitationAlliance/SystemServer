package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
