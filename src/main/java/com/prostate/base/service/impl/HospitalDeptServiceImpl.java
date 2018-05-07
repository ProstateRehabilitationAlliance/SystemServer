package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.HospitalDeptDao;
import com.prostate.base.domain.HospitalDeptDO;
import com.prostate.base.service.HospitalDeptService;



@Service
public class HospitalDeptServiceImpl implements HospitalDeptService {
	@Autowired
	private HospitalDeptDao hospitalDeptDao;
	
	@Override
	public HospitalDeptDO get(String id){
		return hospitalDeptDao.get(id);
	}
	
	@Override
	public List<HospitalDeptDO> list(Map<String, Object> map){
		return hospitalDeptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hospitalDeptDao.count(map);
	}
	
	@Override
	public int save(HospitalDeptDO hospitalDept){
		return hospitalDeptDao.save(hospitalDept);
	}
	
	@Override
	public int update(HospitalDeptDO hospitalDept){
		return hospitalDeptDao.update(hospitalDept);
	}
	
	@Override
	public int remove(String id){
		return hospitalDeptDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return hospitalDeptDao.batchRemove(ids);
	}
	
}
