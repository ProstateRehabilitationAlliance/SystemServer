package com.prostate.user.mapper.read;

import com.prostate.user.entity.FocusCountDoctorDO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 医生关注统计表
 * @author ykbian
 * @email 1992lcg@163.com
 * @date 2018-08-10 15:50:17
 */
@Repository
public interface FocusCountDoctorReadMapper {

	FocusCountDoctorDO get(String id);
	
	List<FocusCountDoctorDO> list(Map<String, Object> map);

	/**
	 * 根据医生id统计数据
	 */
	int countByDoctorId(String doctorId);


	/**
	 * 统计最近一周数据
	 */
	int countThisWeek(String doctorId);


	int count(Map<String, Object> map);
	
	int save(FocusCountDoctorDO countDoctor);
	
	int update(FocusCountDoctorDO countDoctor);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
