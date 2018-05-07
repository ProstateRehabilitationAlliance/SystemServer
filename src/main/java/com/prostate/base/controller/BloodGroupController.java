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

import com.prostate.base.domain.BloodGroupDO;
import com.prostate.base.service.BloodGroupService;
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
@RequestMapping("/base/bloodGroup")
public class BloodGroupController {
	@Autowired
	private BloodGroupService bloodGroupService;
	
	@GetMapping()
	@RequiresPermissions("base:bloodGroup:bloodGroup")
	String BloodGroup(){
	    return "base/bloodGroup/bloodGroup";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:bloodGroup:bloodGroup")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BloodGroupDO> bloodGroupList = bloodGroupService.list(query);
		int total = bloodGroupService.count(query);
		PageUtils pageUtils = new PageUtils(bloodGroupList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:bloodGroup:add")
	String add(){
	    return "base/bloodGroup/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:bloodGroup:edit")
	String edit(@PathVariable("id") String id,Model model){
		BloodGroupDO bloodGroup = bloodGroupService.get(id);
		model.addAttribute("bloodGroup", bloodGroup);
	    return "base/bloodGroup/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:bloodGroup:add")
	public R save( BloodGroupDO bloodGroup){
		if(bloodGroupService.save(bloodGroup)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:bloodGroup:edit")
	public R update( BloodGroupDO bloodGroup){
		bloodGroupService.update(bloodGroup);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:bloodGroup:remove")
	public R remove( String id){
		if(bloodGroupService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:bloodGroup:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		bloodGroupService.batchRemove(ids);
		return R.ok();
	}
	
}
