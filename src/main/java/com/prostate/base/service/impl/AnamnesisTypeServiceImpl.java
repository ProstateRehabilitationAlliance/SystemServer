package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.AnamnesisTypeDao;
import com.prostate.base.domain.AnamnesisTypeDO;
import com.prostate.base.service.AnamnesisTypeService;



@Service
public class AnamnesisTypeServiceImpl implements AnamnesisTypeService {
	@Autowired
	private AnamnesisTypeDao anamnesisTypeDao;
	
	@Override
	public AnamnesisTypeDO get(String id){
		return anamnesisTypeDao.get(id);
	}
	
	@Override
	public List<AnamnesisTypeDO> list(Map<String, Object> map){
		return anamnesisTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return anamnesisTypeDao.count(map);
	}
	
	@Override
	public int save(AnamnesisTypeDO anamnesisType){
		return anamnesisTypeDao.save(anamnesisType);
	}
	
	@Override
	public int update(AnamnesisTypeDO anamnesisType){
		return anamnesisTypeDao.update(anamnesisType);
	}
	
	@Override
	public int remove(String id){
		return anamnesisTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return anamnesisTypeDao.batchRemove(ids);
	}

	@Override
	public List<AnamnesisTypeDO> listByName(String name) {
		return anamnesisTypeDao.listByName(name);
	}

	@Override
	public List<AnamnesisTypeDO> listByNumber(String number) {
		return anamnesisTypeDao.listByNumber(number);
	}

}
