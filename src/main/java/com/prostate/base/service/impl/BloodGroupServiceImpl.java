package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.BloodGroupDao;
import com.prostate.base.domain.BloodGroupDO;
import com.prostate.base.service.BloodGroupService;



@Service
public class BloodGroupServiceImpl implements BloodGroupService {
	@Autowired
	private BloodGroupDao bloodGroupDao;
	
	@Override
	public BloodGroupDO get(String id){
		return bloodGroupDao.get(id);
	}
	
	@Override
	public List<BloodGroupDO> list(Map<String, Object> map){
		return bloodGroupDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bloodGroupDao.count(map);
	}
	
	@Override
	public int save(BloodGroupDO bloodGroup){
		return bloodGroupDao.save(bloodGroup);
	}
	
	@Override
	public int update(BloodGroupDO bloodGroup){
		return bloodGroupDao.update(bloodGroup);
	}
	
	@Override
	public int remove(String id){
		return bloodGroupDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return bloodGroupDao.batchRemove(ids);
	}
	
}
