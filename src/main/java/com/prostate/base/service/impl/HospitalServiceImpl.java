package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.HospitalDao;
import com.prostate.base.domain.HospitalDO;
import com.prostate.base.service.HospitalService;



@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalDao hospitalDao;
	
	@Override
	public HospitalDO get(String id){
		return hospitalDao.get(id);
	}

	@Override
	public HospitalDO getByName(String hospitalName) {
		return hospitalDao.getByName(hospitalName);
	}

	@Override
	public HospitalDO getByNumber(String hospitalNumber) {
		return hospitalDao.getByNumber(hospitalNumber);
	}

	@Override
	public List<HospitalDO> list(Map<String, Object> map){
		return hospitalDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hospitalDao.count(map);
	}
	
	@Override
	public int save(HospitalDO hospital){
		return hospitalDao.save(hospital);
	}
	
	@Override
	public int update(HospitalDO hospital){
		return hospitalDao.update(hospital);
	}
	
	@Override
	public int remove(String id){
		return hospitalDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return hospitalDao.batchRemove(ids);
	}
	
}
