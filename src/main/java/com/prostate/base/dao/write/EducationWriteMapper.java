package com.prostate.base.dao.write;

import com.prostate.base.domain.EducationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface EducationWriteMapper {

	EducationDO get(String id);

	EducationDO getByName(String educationName);

	EducationDO getByNumber(String educationNumber);

	
	List<EducationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EducationDO education);
	
	int update(EducationDO education);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
