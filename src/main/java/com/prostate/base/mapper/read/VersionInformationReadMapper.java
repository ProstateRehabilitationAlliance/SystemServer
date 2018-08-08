package com.prostate.base.mapper.read;

import com.prostate.base.domain.VersionInformationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 版本信息
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-08 09:29:42
 */
@Repository
public interface VersionInformationReadMapper {

	VersionInformationDO get(String id);


	VersionInformationDO getByVersionNumber(String versionNumber);


	List<VersionInformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(VersionInformationDO information);
	
	int update(VersionInformationDO information);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
