package com.prostate.base.dao.write;

import com.prostate.base.domain.IpssDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
public interface IpssManagerWriteMapper {

	IpssDO get(String id);
	
	List<IpssDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IpssDO ipss);
	
	int update(IpssDO ipss);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<IpssDO> listByName(String name);

	List<IpssDO> listByNumber(String number);

	public List<IpssDO> getTree(Map<String, Object> map);
}
