package com.prostate.base.dao;

import com.prostate.base.domain.NationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface NationDao {

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
