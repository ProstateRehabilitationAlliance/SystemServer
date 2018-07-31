package com.prostate.system.mapper.write;

import com.prostate.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-02 20:24:47
 */
public interface RoleWriteMapper {

	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
