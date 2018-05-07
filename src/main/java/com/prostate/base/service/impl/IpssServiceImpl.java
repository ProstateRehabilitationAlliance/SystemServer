package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.IpssDao;
import com.prostate.base.domain.IpssDO;
import com.prostate.base.service.IpssService;



@Service
public class IpssServiceImpl implements IpssService {
	@Autowired
	private IpssDao ipssDao;
	
	@Override
	public IpssDO get(String id){
		return ipssDao.get(id);
	}
	
	@Override
	public List<IpssDO> list(Map<String, Object> map){
		return ipssDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ipssDao.count(map);
	}
	
	@Override
	public int save(IpssDO ipss){
		return ipssDao.save(ipss);
	}
	
	@Override
	public int update(IpssDO ipss){
		return ipssDao.update(ipss);
	}
	
	@Override
	public int remove(String id){
		return ipssDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return ipssDao.batchRemove(ids);
	}
	
}
