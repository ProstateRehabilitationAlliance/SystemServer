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

import com.prostate.base.domain.HospitalDO;
import com.prostate.base.service.HospitalService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 医院表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping()
	@RequiresPermissions("base:hospital:hospital")
	String Hospital(){
	    return "base/hospital/hospital";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:hospital:hospital")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<HospitalDO> hospitalList = hospitalService.list(query);
		int total = hospitalService.count(query);
		PageUtils pageUtils = new PageUtils(hospitalList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:hospital:add")
	String add(){
	    return "base/hospital/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:hospital:edit")
	String edit(@PathVariable("id") String id,Model model){
		HospitalDO hospital = hospitalService.get(id);
		model.addAttribute("hospital", hospital);
	    return "base/hospital/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:hospital:add")
	public R save( HospitalDO hospital){
		if(hospitalService.save(hospital)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:hospital:edit")
	public R update( HospitalDO hospital){
		hospitalService.update(hospital);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:hospital:remove")
	public R remove( String id){
		if(hospitalService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:hospital:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		hospitalService.batchRemove(ids);
		return R.ok();
	}
	
}
