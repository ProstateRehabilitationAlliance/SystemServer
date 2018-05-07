package com.prostate.base.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prostate.base.domain.CityDO;
import com.prostate.base.service.CityService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
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
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:city:city")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CityDO> cityList = cityService.list(query);
		int total = cityService.count(query);
		PageUtils pageUtils = new PageUtils(cityList, total);
		return pageUtils;
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
	public R save( CityDO city){
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
	public R update( CityDO city){
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
	
}
