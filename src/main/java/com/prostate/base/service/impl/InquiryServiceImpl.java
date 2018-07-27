package com.prostate.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.dao.InquiryDao;
import com.prostate.base.domain.InquiryDO;
import com.prostate.base.service.InquiryService;



@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	private InquiryDao inquiryDao;
	
	@Override
	public InquiryDO get(String id){
		return inquiryDao.get(id);
	}
	
	@Override
	public List<InquiryDO> list(Map<String, Object> map){
		return inquiryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return inquiryDao.count(map);
	}
	
	@Override
	public int save(InquiryDO inquiry){
		return inquiryDao.save(inquiry);
	}
	
	@Override
	public int update(InquiryDO inquiry){
		return inquiryDao.update(inquiry);
	}
	
	@Override
	public int remove(String id){
		return inquiryDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return inquiryDao.batchRemove(ids);
	}
	
}
