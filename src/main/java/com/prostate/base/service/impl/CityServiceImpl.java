package com.prostate.base.service.impl;

import com.prostate.base.mapper.read.CityReadMapper;
import com.prostate.base.mapper.write.CityWriteMapper;
import com.prostate.base.service.CityService;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.domain.CityDO;


@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityWriteMapper cityWriteMapper;

	@Autowired
	private CityReadMapper cityReadMapper;


	@Override
	public CityDO get(String id){
		return cityReadMapper.get(id);
	}

	@Override
	public CityDO getParent(String id) {
		return cityReadMapper.getParent(id);
	}

	@Override
	public List<CityDO> getChild(Map<String, Object> map) {
		return cityReadMapper.getChild(map);
	}
	
	@Override
	public List<CityDO> list(Map<String, Object> map){
		return cityReadMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cityReadMapper.count(map);
	}
	
	@Override
	public int save(CityDO city){
		return cityWriteMapper.save(city);
	}
	
	@Override
	public int update(CityDO city){
		return cityWriteMapper.update(city);
	}
	
	@Override
	public int remove(String id){
		return cityWriteMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return cityWriteMapper.batchRemove(ids);
	}

	@Override
	public Tree<CityDO> getTree() {

		List<Tree<CityDO>> trees = new ArrayList<Tree<CityDO>>();
		//查询所有的信息存入列表中。
		List<CityDO> cityDOS = cityReadMapper.list(new HashMap<String,Object>(16));
		//这里生成的都是区县级的节点信息
		for (CityDO cityDO : cityDOS) {
			//声明树形结构
			Tree<CityDO> tree = new Tree<CityDO>();
			//每个树末节点的id
			tree.setId(cityDO.getId().toString());
			//每一个末节点的上级节点
			tree.setParentId(cityDO.getParentCityId().toString());
			//每个节点的文字信息
			tree.setText(cityDO.getCityName());
			//tree
			//如果不是区县级，肯定有下级列表。
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			//每一个树形结构都存入列表
			trees.add(tree);
		}


		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CityDO> t = BuildTree.build(trees);
		return t;

	}
}
