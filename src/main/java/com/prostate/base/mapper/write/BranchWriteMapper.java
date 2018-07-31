package com.prostate.base.mapper.write;

import com.prostate.base.domain.BranchDO;

import java.util.List;
import java.util.Map;

/**
 * 科室表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface BranchWriteMapper {

	BranchDO get(String id);

	BranchDO getByNumber(String branchNumber);

	BranchDO getByName(String branchName);

	List<BranchDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(BranchDO branch);

	int update(BranchDO branch);

	int remove(String id);

	int batchRemove(String[] ids);

	List<BranchDO> listByName(String name);


	List<BranchDO> getTree(Map<String, Object> map);
}
