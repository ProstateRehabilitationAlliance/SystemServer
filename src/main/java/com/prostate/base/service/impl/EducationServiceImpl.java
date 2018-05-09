package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.EducationDao;
import com.prostate.base.domain.EducationDO;
import com.prostate.base.service.EducationService;



@Service
public class EducationServiceImpl implements EducationService {
	@Autowired
	private EducationDao educationDao;
	
	@Override
	public EducationDO get(String id){
		return educationDao.get(id);
	}

	@Override
	public EducationDO getByName(String educationName) {
		return educationDao.getByName(educationName);
	}

	@Override
	public EducationDO getByNumber(String educationNumber) {
		return educationDao.getByNumber(educationNumber);
	}

	@Override
	public List<EducationDO> list(Map<String, Object> map){
		return educationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return educationDao.count(map);
	}
	
	@Override
	public int save(EducationDO education){
		return educationDao.save(education);
	}
	
	@Override
	public int update(EducationDO education){
		return educationDao.update(education);
	}
	
	@Override
	public int remove(String id){
		return educationDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return educationDao.batchRemove(ids);
	}
	
}
