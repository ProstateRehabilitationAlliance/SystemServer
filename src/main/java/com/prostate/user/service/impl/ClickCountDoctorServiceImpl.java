package com.prostate.user.service.impl;

import com.prostate.user.entity.ClickCountDoctorDO;
import com.prostate.user.mapper.read.ClickCountDoctorReadMApper;
import com.prostate.user.service.ClickCountDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class ClickCountDoctorServiceImpl implements ClickCountDoctorService {



	@Autowired
	private ClickCountDoctorReadMApper clickCountDoctorReadMApper;

	@Override
	public List<ClickCountDoctorDO> list(Map<String, Object> map) {
		return null;
	}


	@Override
	public ClickCountDoctorDO get(String id){
		return clickCountDoctorReadMApper.get(id);
	}

	@Override
	public int countByDoctorId(String doctorId) {
		return clickCountDoctorReadMApper.countByDoctorId(doctorId);
	}

	@Override
	public int countThisWeek(String doctorId) {
		return clickCountDoctorReadMApper.countThisWeek(doctorId);
	}

	@Override
	public int count(Map<String, Object> map){
		return clickCountDoctorReadMApper.count(map);
	}
	
	@Override
	public int save(ClickCountDoctorDO countDoctor){
		return clickCountDoctorReadMApper.save(countDoctor);
	}
	
	@Override
	public int update(ClickCountDoctorDO countDoctor){
		return clickCountDoctorReadMApper.update(countDoctor);
	}
	
	@Override
	public int remove(String id){
		return clickCountDoctorReadMApper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return clickCountDoctorReadMApper.batchRemove(ids);
	}
	
}
