package com.prostate.base.mapper.write;

import com.prostate.base.domain.VersionInformationDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 版本信息
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-08 09:29:42
 */
@Repository
public interface VersionInformationWriteMapper {


	
	int save(VersionInformationDO information);
	
	int update(VersionInformationDO information);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
