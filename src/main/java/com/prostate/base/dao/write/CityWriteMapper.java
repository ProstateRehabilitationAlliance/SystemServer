package com.prostate.base.dao.write;

import com.prostate.base.domain.CityDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 城市表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface CityWriteMapper {

	CityDO get(String id);

	CityDO getParent(String id);

	List<CityDO> getChild(Map<String, Object> map);
	
	List<CityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CityDO city);
	
	int update(CityDO city);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
