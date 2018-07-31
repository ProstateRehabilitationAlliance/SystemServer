package com.prostate.base.service.impl;

import com.prostate.base.mapper.read.IllnessReadMapper;
import com.prostate.base.mapper.write.IllnessWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.domain.IllnessDO;
import com.prostate.base.service.IllnessService;



@Service
public class IllnessServiceImpl implements IllnessService {

	@Autowired
	private IllnessWriteMapper illnessWriteMapper;

	@Autowired
	private IllnessReadMapper illnessReadMapper;
	@Override
	public IllnessDO get(String id){
		return illnessReadMapper.get(id);
	}
	
	@Override
	public List<IllnessDO> list(Map<String, Object> map){
		return illnessReadMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return illnessReadMapper.count(map);
	}
	
	@Override
	public int save(IllnessDO illness){
		return illnessWriteMapper.save(illness);
	}
	
	@Override
	public int update(IllnessDO illness){
		return illnessWriteMapper.update(illness);
	}
	
	@Override
	public int remove(String id){
		return illnessWriteMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return illnessWriteMapper.batchRemove(ids);
	}

	@Override
	public List<IllnessDO> listByName(String name) {
		System.out.println("=------------------"+name);
		return illnessReadMapper.listByName(name);
	}

	@Override
	public List<IllnessDO> listByNumber(String number) {
		return illnessReadMapper.listByNumber(number);
	}

}
