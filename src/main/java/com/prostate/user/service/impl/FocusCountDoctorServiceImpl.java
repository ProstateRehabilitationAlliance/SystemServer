package com.prostate.user.service.impl;

import com.prostate.user.mapper.read.FocusCountDoctorReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.user.entity.FocusCountDoctorDO;
import com.prostate.user.service.FocusCountDoctorService;



@Service
public class FocusCountDoctorServiceImpl implements FocusCountDoctorService {

	@Autowired
	private FocusCountDoctorReadMapper countDoctorDao;

	@Override
	public int countByDoctorId(String doctorId) {
		return countDoctorDao.countByDoctorId(doctorId);
	}


	@Override
	public int countThisWeek(String doctorId) {
		return countDoctorDao.countThisWeek(doctorId);
	}


	@Override
	public FocusCountDoctorDO get(String id){
		return countDoctorDao.get(id);
	}
	
	@Override
	public List<FocusCountDoctorDO> list(Map<String, Object> map){
		return countDoctorDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return countDoctorDao.count(map);
	}
	
	@Override
	public int save(FocusCountDoctorDO countDoctor){
		return countDoctorDao.save(countDoctor);
	}
	
	@Override
	public int update(FocusCountDoctorDO countDoctor){
		return countDoctorDao.update(countDoctor);
	}
	
	@Override
	public int remove(String id){
		return countDoctorDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return countDoctorDao.batchRemove(ids);
	}
	
}
