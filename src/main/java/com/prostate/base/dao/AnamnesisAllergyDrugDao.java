package com.prostate.base.dao;

import com.prostate.base.domain.AnamnesisAllergyDrugDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
@Mapper
public interface AnamnesisAllergyDrugDao {


	AnamnesisAllergyDrugDO get(String id);

	AnamnesisAllergyDrugDO getByName(String allergyDrugName);

	AnamnesisAllergyDrugDO getByNumber(String allergyDrugNumber);
	
	List<AnamnesisAllergyDrugDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AnamnesisAllergyDrugDO anamnesisAllergyDrug);
	
	int update(AnamnesisAllergyDrugDO anamnesisAllergyDrug);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
