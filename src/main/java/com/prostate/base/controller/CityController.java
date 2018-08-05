package com.prostate.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.base.domain.GroupID;
import com.prostate.base.domain.GroupWithoutID;
import com.prostate.base.service.CityService;
import com.prostate.base.vo.CityVO;
import com.prostate.common.domain.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prostate.base.domain.CityDO;
import com.prostate.common.utils.R;

/**
 * 城市表
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */

@Controller
@RequestMapping("/base/city")
public class CityController {
	@Autowired
	private CityService cityService;


	@GetMapping()
	@RequiresPermissions("base:city:city")
	String City(){
	    return "base/city/city";
	}


@GetMapping("/list")
@ResponseBody
public List<CityDO> list() {
	Map<String, Object> query = new HashMap<>(16);
	List<CityDO> sysBranchList = cityService.list(query);
	return sysBranchList;
}



	@ResponseBody
	@GetMapping("/ChildList")
	public List<CityDO> ChildList(String parentCityId) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("parentCityId",parentCityId);
		List<CityDO> sysBranchList = cityService.getChild(query);
		return sysBranchList;
	}



	@GetMapping("/add")
	@RequiresPermissions("base:city:add")
	String add(){
	    return "base/city/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:city:edit")
	String edit(@PathVariable("id") String id,Model model){
		CityDO city = cityService.get(id);
		model.addAttribute("city", city);
	    return "base/city/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:city:add")
	public R save(@Validated(GroupWithoutID.class) CityDO city){
		if(cityService.save(city)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:city:edit")
	public R update(@Validated({GroupID.class,GroupWithoutID.class}) CityDO city){
		cityService.update(city);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:city:remove")
	public R remove( String id){
		if(cityService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:city:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		cityService.batchRemove(ids);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/getById")
	//@RequiresPermissions("base:city:city")
	public CityVO getById(String id){
		CityVO cityVO = new CityVO();
		//分别获取三级信息
		CityDO cityDOCounty  = cityService.get(id);
		CityDO cityDOCity  = cityService.get(cityDOCounty.getParentCityId());
		CityDO cityDOProvince  = cityService.get(cityDOCity.getParentCityId());
		cityVO.setProvince(cityDOProvince);
		cityVO.setCity(cityDOCity);
		cityVO.setCounty(cityDOCounty);
		return cityVO;
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<CityDO> tree() {
		Tree<CityDO> tree = new Tree<CityDO>();
		tree = cityService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return   "base/city/cityTree";
	}
}
