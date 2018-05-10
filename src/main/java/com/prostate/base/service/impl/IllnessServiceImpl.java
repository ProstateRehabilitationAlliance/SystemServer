package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.IllnessDao;
import com.prostate.base.domain.IllnessDO;
import com.prostate.base.service.IllnessService;



@Service
public class IllnessServiceImpl implements IllnessService {

	@Autowired
	private IllnessDao illnessDao;
	
	@Override
	public IllnessDO get(String id){
		return illnessDao.get(id);
	}
	
	@Override
	public List<IllnessDO> list(Map<String, Object> map){
		return illnessDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return illnessDao.count(map);
	}
	
	@Override
	public int save(IllnessDO illness){
		return illnessDao.save(illness);
	}
	
	@Override
	public int update(IllnessDO illness){
		return illnessDao.update(illness);
	}
	
	@Override
	public int remove(String id){
		return illnessDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return illnessDao.batchRemove(ids);
	}

	@Override
	public List<IllnessDO> listByName(String name) {
		System.out.println("=------------------"+name);
		return illnessDao.listByName(name);
	}

	@Override
	public List<IllnessDO> listByNumber(String number) {
		return illnessDao.listByNumber(number);
	}

}
