package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.DoctorTitleDao;
import com.prostate.base.domain.DoctorTitleDO;
import com.prostate.base.service.DoctorTitleService;



@Service
public class DoctorTitleServiceImpl implements DoctorTitleService {
	@Autowired
	private DoctorTitleDao doctorTitleDao;
	
	@Override
	public DoctorTitleDO get(String id){
		return doctorTitleDao.get(id);
	}
	
	@Override
	public List<DoctorTitleDO> list(Map<String, Object> map){
		return doctorTitleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return doctorTitleDao.count(map);
	}
	
	@Override
	public int save(DoctorTitleDO doctorTitle){
		return doctorTitleDao.save(doctorTitle);
	}
	
	@Override
	public int update(DoctorTitleDO doctorTitle){
		return doctorTitleDao.update(doctorTitle);
	}
	
	@Override
	public int remove(String id){
		return doctorTitleDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return doctorTitleDao.batchRemove(ids);
	}
	
}
