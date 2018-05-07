package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.AnamnesisAllergyDrugDao;
import com.prostate.base.domain.AnamnesisAllergyDrugDO;
import com.prostate.base.service.AnamnesisAllergyDrugService;



@Service
public class AnamnesisAllergyDrugServiceImpl implements AnamnesisAllergyDrugService {
	@Autowired
	private AnamnesisAllergyDrugDao anamnesisAllergyDrugDao;
	
	@Override
	public AnamnesisAllergyDrugDO get(String id){
		return anamnesisAllergyDrugDao.get(id);
	}
	
	@Override
	public List<AnamnesisAllergyDrugDO> list(Map<String, Object> map){
		return anamnesisAllergyDrugDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return anamnesisAllergyDrugDao.count(map);
	}
	
	@Override
	public int save(AnamnesisAllergyDrugDO anamnesisAllergyDrug){
		return anamnesisAllergyDrugDao.save(anamnesisAllergyDrug);
	}
	
	@Override
	public int update(AnamnesisAllergyDrugDO anamnesisAllergyDrug){
		return anamnesisAllergyDrugDao.update(anamnesisAllergyDrug);
	}
	
	@Override
	public int remove(String id){
		return anamnesisAllergyDrugDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return anamnesisAllergyDrugDao.batchRemove(ids);
	}
	
}
