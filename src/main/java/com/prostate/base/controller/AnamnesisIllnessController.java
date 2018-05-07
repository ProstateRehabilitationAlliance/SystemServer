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

import com.prostate.base.domain.AnamnesisIllnessDO;
import com.prostate.base.service.AnamnesisIllnessService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/anamnesisIllness")
public class AnamnesisIllnessController {
	@Autowired
	private AnamnesisIllnessService anamnesisIllnessService;
	
	@GetMapping()
	@RequiresPermissions("base:anamnesisIllness:anamnesisIllness")
	String AnamnesisIllness(){
	    return "base/anamnesisIllness/anamnesisIllness";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:anamnesisIllness:anamnesisIllness")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AnamnesisIllnessDO> anamnesisIllnessList = anamnesisIllnessService.list(query);
		int total = anamnesisIllnessService.count(query);
		PageUtils pageUtils = new PageUtils(anamnesisIllnessList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:anamnesisIllness:add")
	String add(){
	    return "base/anamnesisIllness/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:anamnesisIllness:edit")
	String edit(@PathVariable("id") String id,Model model){
		AnamnesisIllnessDO anamnesisIllness = anamnesisIllnessService.get(id);
		model.addAttribute("anamnesisIllness", anamnesisIllness);
	    return "base/anamnesisIllness/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:anamnesisIllness:add")
	public R save( AnamnesisIllnessDO anamnesisIllness){
		if(anamnesisIllnessService.save(anamnesisIllness)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:anamnesisIllness:edit")
	public R update( AnamnesisIllnessDO anamnesisIllness){
		anamnesisIllnessService.update(anamnesisIllness);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisIllness:remove")
	public R remove( String id){
		if(anamnesisIllnessService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisIllness:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		anamnesisIllnessService.batchRemove(ids);
		return R.ok();
	}
	
}
