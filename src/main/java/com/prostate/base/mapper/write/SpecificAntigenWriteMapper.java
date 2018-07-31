package com.prostate.base.mapper.write;

import com.prostate.base.domain.SpecificAntigenDO;

import java.util.List;
import java.util.Map;

/**
 * 特异性抗原量表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-04 15:18:12
 */
public interface SpecificAntigenWriteMapper {

	SpecificAntigenDO get(String id);
	
	List<SpecificAntigenDO> list(Map<String, Object> map);

	List<SpecificAntigenDO> getByParentId(String id);

	int count(Map<String, Object> map);
	
	int save(SpecificAntigenDO specificAntigen);
	
	int update(SpecificAntigenDO specificAntigen);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

}
