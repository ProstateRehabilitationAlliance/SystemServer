package com.prostate.base.dao;

import com.prostate.base.domain.InquiryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会诊类型标签
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-26 13:09:03
 */
@Mapper
public interface InquiryDao {

	InquiryDO get(String id);
	
	List<InquiryDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(InquiryDO inquiry);
	
	int update(InquiryDO inquiry);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
