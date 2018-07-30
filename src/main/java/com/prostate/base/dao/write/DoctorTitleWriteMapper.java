package com.prostate.base.dao.write;

import com.prostate.base.domain.DoctorTitleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface DoctorTitleWriteMapper {

	DoctorTitleDO get(String id);

	DoctorTitleDO getByName(String doctorTitleName);

	DoctorTitleDO getByNumber(String doctorTitleNumber);
	
	List<DoctorTitleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DoctorTitleDO doctorTitle);
	
	int update(DoctorTitleDO doctorTitle);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
