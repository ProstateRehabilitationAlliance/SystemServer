package com.prostate.base.service.impl;

import com.prostate.base.dao.read.HospitalTypeReadMapper;
import com.prostate.base.dao.write.HospitalTypeWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.domain.HospitalTypeDO;
import com.prostate.base.service.HospitalTypeService;



@Service
public class HospitalTypeServiceImpl implements HospitalTypeService {
	@Autowired
	private HospitalTypeWriteMapper hospitalTypeWriteMapper;

	@Autowired
	private HospitalTypeReadMapper hospitalTypeReadMapper;

	@Override
	public HospitalTypeDO get(String id){
		return hospitalTypeReadMapper.get(id);
	}
	
	@Override
	public List<HospitalTypeDO> list(Map<String, Object> map){
		return hospitalTypeReadMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hospitalTypeReadMapper.count(map);
	}
	
	@Override
	public int save(HospitalTypeDO hospitalType){
		return hospitalTypeWriteMapper.save(hospitalType);
	}
	
	@Override
	public int update(HospitalTypeDO hospitalType){
		return hospitalTypeWriteMapper.update(hospitalType);
	}
	
	@Override
	public int remove(String id){
		return hospitalTypeWriteMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return hospitalTypeWriteMapper.batchRemove(ids);
	}

	@Override
	public List<HospitalTypeDO> listByName(String name) {
		return hospitalTypeReadMapper.listByName(name);
	}

	@Override
	public List<HospitalTypeDO> listByNumber(String number) {
		return hospitalTypeReadMapper.listByNumber(number);
	}

}
