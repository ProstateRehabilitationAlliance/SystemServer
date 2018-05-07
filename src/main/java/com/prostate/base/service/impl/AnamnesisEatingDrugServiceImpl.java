package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.AnamnesisEatingDrugDao;
import com.prostate.base.domain.AnamnesisEatingDrugDO;
import com.prostate.base.service.AnamnesisEatingDrugService;



@Service
public class AnamnesisEatingDrugServiceImpl implements AnamnesisEatingDrugService {
	@Autowired
	private AnamnesisEatingDrugDao anamnesisEatingDrugDao;
	
	@Override
	public AnamnesisEatingDrugDO get(String id){
		return anamnesisEatingDrugDao.get(id);
	}
	
	@Override
	public List<AnamnesisEatingDrugDO> list(Map<String, Object> map){
		return anamnesisEatingDrugDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return anamnesisEatingDrugDao.count(map);
	}
	
	@Override
	public int save(AnamnesisEatingDrugDO anamnesisEatingDrug){
		return anamnesisEatingDrugDao.save(anamnesisEatingDrug);
	}
	
	@Override
	public int update(AnamnesisEatingDrugDO anamnesisEatingDrug){
		return anamnesisEatingDrugDao.update(anamnesisEatingDrug);
	}
	
	@Override
	public int remove(String id){
		return anamnesisEatingDrugDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return anamnesisEatingDrugDao.batchRemove(ids);
	}
	
}
