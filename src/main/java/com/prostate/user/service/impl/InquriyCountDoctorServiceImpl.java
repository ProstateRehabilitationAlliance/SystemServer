package com.prostate.user.service.impl;

import com.prostate.user.mapper.read.InquriyCountDoctorReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.user.entity.InquriyCountDoctorDO;
import com.prostate.user.service.InquriyCountDoctorService;



@Service
public class InquriyCountDoctorServiceImpl implements InquriyCountDoctorService {


	@Autowired
	private InquriyCountDoctorReadMapper inquriyCountDoctorReadMapper;

	@Override
	public int countByDoctorId(String doctorId) {
		return inquriyCountDoctorReadMapper.countByDoctorId(doctorId);
	}


	@Override
	public int countThisWeek(String doctorId) {
		return inquriyCountDoctorReadMapper.countThisWeek(doctorId);
	}


	@Override
	public InquriyCountDoctorDO get(String id){
		return inquriyCountDoctorReadMapper.get(id);
	}
	
	@Override
	public List<InquriyCountDoctorDO> list(Map<String, Object> map){
		return inquriyCountDoctorReadMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return inquriyCountDoctorReadMapper.count(map);
	}
	
	@Override
	public int save(InquriyCountDoctorDO countDoctor){
		return inquriyCountDoctorReadMapper.save(countDoctor);
	}
	
	@Override
	public int update(InquriyCountDoctorDO countDoctor){
		return inquriyCountDoctorReadMapper.update(countDoctor);
	}
	
	@Override
	public int remove(String id){
		return inquriyCountDoctorReadMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return inquriyCountDoctorReadMapper.batchRemove(ids);
	}
	
}
