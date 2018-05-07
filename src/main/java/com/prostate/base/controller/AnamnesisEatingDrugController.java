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

import com.prostate.base.domain.AnamnesisEatingDrugDO;
import com.prostate.base.service.AnamnesisEatingDrugService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/anamnesisEatingDrug")
public class AnamnesisEatingDrugController {
	@Autowired
	private AnamnesisEatingDrugService anamnesisEatingDrugService;
	
	@GetMapping()
	@RequiresPermissions("base:anamnesisEatingDrug:anamnesisEatingDrug")
	String AnamnesisEatingDrug(){
	    return "base/anamnesisEatingDrug/anamnesisEatingDrug";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:anamnesisEatingDrug:anamnesisEatingDrug")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AnamnesisEatingDrugDO> anamnesisEatingDrugList = anamnesisEatingDrugService.list(query);
		int total = anamnesisEatingDrugService.count(query);
		PageUtils pageUtils = new PageUtils(anamnesisEatingDrugList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:anamnesisEatingDrug:add")
	String add(){
	    return "base/anamnesisEatingDrug/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:anamnesisEatingDrug:edit")
	String edit(@PathVariable("id") String id,Model model){
		AnamnesisEatingDrugDO anamnesisEatingDrug = anamnesisEatingDrugService.get(id);
		model.addAttribute("anamnesisEatingDrug", anamnesisEatingDrug);
	    return "base/anamnesisEatingDrug/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:anamnesisEatingDrug:add")
	public R save( AnamnesisEatingDrugDO anamnesisEatingDrug){
		if(anamnesisEatingDrugService.save(anamnesisEatingDrug)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:anamnesisEatingDrug:edit")
	public R update( AnamnesisEatingDrugDO anamnesisEatingDrug){
		anamnesisEatingDrugService.update(anamnesisEatingDrug);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisEatingDrug:remove")
	public R remove( String id){
		if(anamnesisEatingDrugService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisEatingDrug:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		anamnesisEatingDrugService.batchRemove(ids);
		return R.ok();
	}
	
}
