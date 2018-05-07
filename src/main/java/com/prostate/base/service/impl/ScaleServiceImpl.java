package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.ScaleDao;
import com.prostate.base.domain.ScaleDO;
import com.prostate.base.service.ScaleService;



@Service
public class ScaleServiceImpl implements ScaleService {
	@Autowired
	private ScaleDao scaleDao;
	
	@Override
	public ScaleDO get(String id){
		return scaleDao.get(id);
	}
	
	@Override
	public List<ScaleDO> list(Map<String, Object> map){
		return scaleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scaleDao.count(map);
	}
	
	@Override
	public int save(ScaleDO scale){
		return scaleDao.save(scale);
	}
	
	@Override
	public int update(ScaleDO scale){
		return scaleDao.update(scale);
	}
	
	@Override
	public int remove(String id){
		return scaleDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return scaleDao.batchRemove(ids);
	}
	
}
