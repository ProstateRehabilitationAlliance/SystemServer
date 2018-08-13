package com.prostate.user.mapper.read;


import java.util.List;
import java.util.Map;

import com.prostate.user.entity.DoctorDetailDO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 医生个人信息表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-13 18:04:59
 */
@Repository
public interface DoctorDetailsReadMapper {

	DoctorDetailDO get(String id);
	
	List<DoctorDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	

}
