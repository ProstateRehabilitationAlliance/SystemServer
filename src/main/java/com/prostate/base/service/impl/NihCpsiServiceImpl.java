package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.NihCpsiDao;
import com.prostate.base.domain.NihCpsiDO;
import com.prostate.base.service.NihCpsiService;



@Service
public class NihCpsiServiceImpl implements NihCpsiService {
	@Autowired
	private NihCpsiDao nihCpsiDao;
	
	@Override
	public NihCpsiDO get(String id){
		return nihCpsiDao.get(id);
	}
	
	@Override
	public List<NihCpsiDO> list(Map<String, Object> map){
		return nihCpsiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return nihCpsiDao.count(map);
	}
	
	@Override
	public int save(NihCpsiDO nihCpsi){
		return nihCpsiDao.save(nihCpsi);
	}
	
	@Override
	public int update(NihCpsiDO nihCpsi){
		return nihCpsiDao.update(nihCpsi);
	}
	
	@Override
	public int remove(String id){
		return nihCpsiDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return nihCpsiDao.batchRemove(ids);
	}
	
}
