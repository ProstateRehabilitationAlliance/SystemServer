package com.prostate.base.mapper.write;

import com.prostate.base.domain.IllnessDO;

import java.util.List;
import java.util.Map;

/**
 * 疾病表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */

public interface IllnessWriteMapper {

	IllnessDO get(String id);
	
	List<IllnessDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IllnessDO illness);
	
	int update(IllnessDO illness);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<IllnessDO> listByName(String name);

	List<IllnessDO> listByNumber(String number);
}