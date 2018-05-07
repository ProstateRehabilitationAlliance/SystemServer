package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.DeptIllnessDao;
import com.prostate.base.domain.DeptIllnessDO;
import com.prostate.base.service.DeptIllnessService;



@Service
public class DeptIllnessServiceImpl implements DeptIllnessService {
	@Autowired
	private DeptIllnessDao deptIllnessDao;
	
	@Override
	public DeptIllnessDO get(String id){
		return deptIllnessDao.get(id);
	}
	
	@Override
	public List<DeptIllnessDO> list(Map<String, Object> map){
		return deptIllnessDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return deptIllnessDao.count(map);
	}
	
	@Override
	public int save(DeptIllnessDO deptIllness){
		return deptIllnessDao.save(deptIllness);
	}
	
	@Override
	public int update(DeptIllnessDO deptIllness){
		return deptIllnessDao.update(deptIllness);
	}
	
	@Override
	public int remove(String id){
		return deptIllnessDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return deptIllnessDao.batchRemove(ids);
	}
	
}
