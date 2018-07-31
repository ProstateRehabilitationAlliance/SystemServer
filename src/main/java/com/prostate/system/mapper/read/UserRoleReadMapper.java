package com.prostate.system.mapper.read;

import com.prostate.system.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 11:08:59
 */
public interface UserRoleReadMapper {

	UserRoleDO get(Long id);

	List<UserRoleDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	List<Long> listRoleId(Long userId);

}