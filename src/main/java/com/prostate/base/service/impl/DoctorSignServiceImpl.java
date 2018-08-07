package com.prostate.base.service.impl;


import com.prostate.base.mapper.read.DoctorSingReadMapper;
import com.prostate.base.mapper.write.DoctorSingWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.prostate.base.domain.DoctorSignDO;
import com.prostate.base.service.DoctorSignService;



@Service
public class DoctorSignServiceImpl implements DoctorSignService {

	@Autowired
	private DoctorSingReadMapper doctorSingReadMapper;

	@Autowired
	private DoctorSingWriteMapper doctorSingWriteMapper;



	@Override
	public DoctorSignDO get(String id){
		return doctorSingReadMapper.get(id);
	}

	@Override
	public List<DoctorSignDO> list(Map<String, Object> map){
		return doctorSingReadMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return doctorSingReadMapper.count(map);
	}

	@Override
	public int save(DoctorSignDO sign){
		return 0;
	}

	@Override
	public int update(DoctorSignDO sign){
		return doctorSingWriteMapper.update(sign);
	}

	@Override
	public int remove(String id){
		return 0;
	}

	@Override
	public int batchRemove(String[] ids){
		return 0;
	}



}
