package com.prostate.base.dao.write;

import com.prostate.base.domain.ExpressedProstaticSecretionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 前列腺按摩液量表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-04 15:18:12
 */
public interface ExpressedProstaticSecretionWriteMapper {

	ExpressedProstaticSecretionDO get(String id);
	
	List<ExpressedProstaticSecretionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExpressedProstaticSecretionDO expressedProstaticSecretion);
	
	int update(ExpressedProstaticSecretionDO expressedProstaticSecretion);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
