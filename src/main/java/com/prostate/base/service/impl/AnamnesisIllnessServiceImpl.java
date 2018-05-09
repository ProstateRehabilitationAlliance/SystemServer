package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.AnamnesisIllnessDao;
import com.prostate.base.domain.AnamnesisIllnessDO;
import com.prostate.base.service.AnamnesisIllnessService;



@Service
public class AnamnesisIllnessServiceImpl implements AnamnesisIllnessService {
	@Autowired
	private AnamnesisIllnessDao anamnesisIllnessDao;
	
	@Override
	public AnamnesisIllnessDO get(String id){
		return anamnesisIllnessDao.get(id);
	}
	
	@Override
	public List<AnamnesisIllnessDO> list(Map<String, Object> map){
		return anamnesisIllnessDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return anamnesisIllnessDao.count(map);
	}
	
	@Override
	public int save(AnamnesisIllnessDO anamnesisIllness){
		return anamnesisIllnessDao.save(anamnesisIllness);
	}
	
	@Override
	public int update(AnamnesisIllnessDO anamnesisIllness){
		return anamnesisIllnessDao.update(anamnesisIllness);
	}
	
	@Override
	public int remove(String id){
		return anamnesisIllnessDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return anamnesisIllnessDao.batchRemove(ids);
	}

	@Override
	public List<AnamnesisIllnessDO> listByName(String name) {
		return anamnesisIllnessDao.listByName(name);
	}

	@Override
	public List<AnamnesisIllnessDO> listByNumber(String number) {
		return anamnesisIllnessDao.listByNumber(number);
	}

}
