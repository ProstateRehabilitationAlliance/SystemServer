package com.prostate.system.mapper.write;

import com.prostate.system.domain.DeptDO;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:35:39
 */
@Repository
public interface DeptWriteMapper {

	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);

}
