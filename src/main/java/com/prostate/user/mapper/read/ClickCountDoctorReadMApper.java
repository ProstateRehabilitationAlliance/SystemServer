package com.prostate.user.mapper.read;


import java.util.List;
import java.util.Map;

import com.prostate.user.entity.ClickCountDoctorDO;
import org.springframework.stereotype.Repository;

/**
 * 医生之点击统计
 * @author ykbian
 * @email 1992lcg@163.com
 * @date 2018-08-10 15:50:11
 */
@Repository
public interface ClickCountDoctorReadMApper {

	ClickCountDoctorDO get(String id);
	
	List<ClickCountDoctorDO> list(Map<String, Object> map);

	/**
	 * 根据医生id统计数据
	 */
	int countByDoctorId(String doctorId);


	/**
	 * 统计最近一周数据
	 */
	int countThisWeek(String doctorId);


	int count(Map<String, Object> map);
	
	int save(ClickCountDoctorDO countDoctor);
	
	int update(ClickCountDoctorDO countDoctor);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
