package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.HospitalTypeDao;
import com.prostate.base.domain.HospitalTypeDO;
import com.prostate.base.service.HospitalTypeService;



@Service
public class HospitalTypeServiceImpl implements HospitalTypeService {
	@Autowired
	private HospitalTypeDao hospitalTypeDao;
	
	@Override
	public HospitalTypeDO get(String id){
		return hospitalTypeDao.get(id);
	}
	
	@Override
	public List<HospitalTypeDO> list(Map<String, Object> map){
		return hospitalTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hospitalTypeDao.count(map);
	}
	
	@Override
	public int save(HospitalTypeDO hospitalType){
		return hospitalTypeDao.save(hospitalType);
	}
	
	@Override
	public int update(HospitalTypeDO hospitalType){
		return hospitalTypeDao.update(hospitalType);
	}
	
	@Override
	public int remove(String id){
		return hospitalTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return hospitalTypeDao.batchRemove(ids);
	}
	
}
