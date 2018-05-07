package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.ProfessionDao;
import com.prostate.base.domain.ProfessionDO;
import com.prostate.base.service.ProfessionService;



@Service
public class ProfessionServiceImpl implements ProfessionService {
	@Autowired
	private ProfessionDao professionDao;
	
	@Override
	public ProfessionDO get(String id){
		return professionDao.get(id);
	}
	
	@Override
	public List<ProfessionDO> list(Map<String, Object> map){
		return professionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return professionDao.count(map);
	}
	
	@Override
	public int save(ProfessionDO profession){
		return professionDao.save(profession);
	}
	
	@Override
	public int update(ProfessionDO profession){
		return professionDao.update(profession);
	}
	
	@Override
	public int remove(String id){
		return professionDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return professionDao.batchRemove(ids);
	}
	
}
