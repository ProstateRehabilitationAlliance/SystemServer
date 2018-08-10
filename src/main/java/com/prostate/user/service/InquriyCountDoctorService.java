package com.prostate.user.service;

import com.prostate.user.entity.InquriyCountDoctorDO;

import java.util.List;
import java.util.Map;

/**
 * 医生之问诊统计
 * 
 * @author ykbian
 * @email 1992lcg@163.com
 * @date 2018-08-10 15:50:24
 */
public interface InquriyCountDoctorService {
	
	InquriyCountDoctorDO get(String id);
	
	List<InquriyCountDoctorDO> list(Map<String, Object> map);

	/**
	 * 根据医生id统计数据
	 */
	int countByDoctorId(String doctorId);

	/**
	 * 统计最近一周数据
	 */
	int countThisWeek(String doctorId);


	int count(Map<String, Object> map);
	
	int save(InquriyCountDoctorDO countDoctor);
	
	int update(InquriyCountDoctorDO countDoctor);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
