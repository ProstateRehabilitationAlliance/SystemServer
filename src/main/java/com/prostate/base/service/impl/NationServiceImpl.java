package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.NationDao;
import com.prostate.base.domain.NationDO;
import com.prostate.base.service.NationService;



@Service
public class NationServiceImpl implements NationService {
	@Autowired
	private NationDao nationDao;
	
	@Override
	public NationDO get(String id){
		return nationDao.get(id);
	}
	
	@Override
	public List<NationDO> list(Map<String, Object> map){
		return nationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return nationDao.count(map);
	}
	
	@Override
	public int save(NationDO nation){
		return nationDao.save(nation);
	}
	
	@Override
	public int update(NationDO nation){
		return nationDao.update(nation);
	}
	
	@Override
	public int remove(String id){
		return nationDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return nationDao.batchRemove(ids);
	}
	
}
