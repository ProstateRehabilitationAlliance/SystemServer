package com.prostate.base.service.impl;

import com.prostate.base.mapper.read.FeedbackReadMapper;
import com.prostate.base.mapper.write.FeedbackWriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prostate.base.domain.FeedbackDO;
import com.prostate.base.service.FeedbackService;

import java.util.List;
import java.util.Map;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackWriteMapper feedbackWriteMapper;

	@Autowired
	private FeedbackReadMapper feedbackReadMapper;

	@Override
	public FeedbackDO get(String id) {
		return feedbackReadMapper.get(id);
	}

	@Override
	public List<FeedbackDO> list(Map<String, Object> map) {
		return feedbackReadMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return feedbackReadMapper.count(map);
	}

	@Override
	public int update(FeedbackDO feedback) {
		return 0;
	}

	@Override
	public int remove(String id) {
		return 0;
	}

	@Override
	public int batchRemove(String[] ids) {
		return 0;
	}

	@Override
	public int save(FeedbackDO feedback){
		return feedbackWriteMapper.save(feedback);
	}
	

	
}
