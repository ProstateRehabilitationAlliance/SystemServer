package com.prostate.base.service.impl;

import com.prostate.base.dao.read.CityReadMapper;
import com.prostate.base.dao.write.CityWriteMapper;
import com.prostate.base.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.domain.CityDO;


@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityWriteMapper cityWriteMapper;

	@Autowired
	private CityReadMapper cityReadMapper;
	
	@Override
	public CityDO get(String id){
		return cityReadMapper.get(id);
	}

	@Override
	public CityDO getParent(String id) {
		return cityReadMapper.getParent(id);
	}

	@Override
	public List<CityDO> getChild(Map<String, Object> map) {
		return cityReadMapper.getChild(map);
	}
	
	@Override
	public List<CityDO> list(Map<String, Object> map){
		return cityReadMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cityReadMapper.count(map);
	}
	
	@Override
	public int save(CityDO city){
		return cityWriteMapper.save(city);
	}
	
	@Override
	public int update(CityDO city){
		return cityWriteMapper.update(city);
	}
	
	@Override
	public int remove(String id){
		return cityWriteMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return cityWriteMapper.batchRemove(ids);
	}
	
}
