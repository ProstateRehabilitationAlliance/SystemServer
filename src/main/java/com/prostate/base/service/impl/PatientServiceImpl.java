package com.prostate.base.service.impl;

import com.prostate.base.dao.PatientDao;
import com.prostate.base.domain.PatientDO;
import com.prostate.base.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao patientDao;
	
	@Override
	public PatientDO get(String id){
		return patientDao.get(id);
	}
	
	@Override
	public List<PatientDO> list(Map<String, Object> map){
		return patientDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return patientDao.count(map);
	}
	
	@Override
	public int save(PatientDO patient){
		return patientDao.save(patient);
	}
	
	@Override
	public int update(PatientDO patient){
		return patientDao.update(patient);
	}
	
	@Override
	public int remove(String id){
		return patientDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return patientDao.batchRemove(ids);
	}
	
}
