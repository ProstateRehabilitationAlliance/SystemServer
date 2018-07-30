package com.prostate.base.dao.read;

import com.prostate.base.domain.NationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface NationReadMapper {

	NationDO get(String id);

	NationDO getByName(String nationName);

	NationDO getByNumber(String nationNumber);

//	int batchUpdate(String[] ids);

	List<NationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NationDO nation);
	
	int update(NationDO nation);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
