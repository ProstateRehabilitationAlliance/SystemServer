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

import com.prostate.base.domain.AnamnesisTypeDO;
import com.prostate.base.service.AnamnesisTypeService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 
 * 
 * @author xiaobai
 * @email 1992lcg@163.com
 * @date 2018-05-04 14:46:36
 */
 
@Controller
@RequestMapping("/base/anamnesisType")
public class AnamnesisTypeController {
	@Autowired
	private AnamnesisTypeService anamnesisTypeService;
	
	@GetMapping()
	@RequiresPermissions("base:anamnesisType:anamnesisType")
	String AnamnesisType(){
	    return "base/anamnesisType/anamnesisType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:anamnesisType:anamnesisType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("delFlag","0");
        Query query = new Query(params);
		List<AnamnesisTypeDO> anamnesisTypeList = anamnesisTypeService.list(query);
		int total = anamnesisTypeService.count(query);
		PageUtils pageUtils = new PageUtils(anamnesisTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:anamnesisType:add")
	String add(){
	    return "base/anamnesisType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:anamnesisType:edit")
	String edit(@PathVariable("id") String id,Model model){
		AnamnesisTypeDO anamnesisType = anamnesisTypeService.get(id);
		model.addAttribute("anamnesisType", anamnesisType);
	    return "base/anamnesisType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:anamnesisType:add")
	public R save( AnamnesisTypeDO anamnesisType){
		if(anamnesisTypeService.save(anamnesisType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:anamnesisType:edit")
	public R update( AnamnesisTypeDO anamnesisType){
		anamnesisTypeService.update(anamnesisType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisType:remove")
	public R remove( String id){
		if(anamnesisTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 *     删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		anamnesisTypeService.batchRemove(ids);
		return R.ok();
	}
	
}
