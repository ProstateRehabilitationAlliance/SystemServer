package com.prostate.base.service.impl;

import com.prostate.base.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.CityDao;
import com.prostate.base.domain.CityDO;


@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;
	
	@Override
	public CityDO get(String id){
		return cityDao.get(id);
	}

	@Override
	public CityDO getParent(String id) {
		return cityDao.getParent(id);
	}

	@Override
	public List<CityDO> getChild(Map<String, Object> map) {
		return cityDao.getChild(map);
	}
	
	@Override
	public List<CityDO> list(Map<String, Object> map){
		return cityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cityDao.count(map);
	}
	
	@Override
	public int save(CityDO city){
		return cityDao.save(city);
	}
	
	@Override
	public int update(CityDO city){
		return cityDao.update(city);
	}
	
	@Override
	public int remove(String id){
		return cityDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return cityDao.batchRemove(ids);
	}
	
}
