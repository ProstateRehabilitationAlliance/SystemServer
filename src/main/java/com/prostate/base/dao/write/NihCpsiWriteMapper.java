package com.prostate.base.dao.write;

import com.prostate.base.domain.NihCpsiDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface NihCpsiWriteMapper {

	NihCpsiDO get(String id);
	
	List<NihCpsiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NihCpsiDO nihCpsi);
	
	int update(NihCpsiDO nihCpsi);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
