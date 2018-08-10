package com.prostate.user.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prostate.user.entity.FocusCountDoctorDO;
import com.prostate.user.service.FocusCountDoctorService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 医生关注统计表
 * 
 * @author ykbian
 * @email 1992lcg@163.com
 * @date 2018-08-10 15:50:17
 */
 
@Controller
@RequestMapping("/user/focusCountDoctor")
public class FocusCountDoctorController {
	@Autowired
	private FocusCountDoctorService focusCountDoctorService;
	
	@GetMapping()
	@RequiresPermissions("user:focusCountDoctor:focusCountDoctor")
	String CountDoctor(){
	    return "user/focusCountDoctor/focusCountDoctor";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("user:focusCountDoctor:focusCountDoctor")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FocusCountDoctorDO> countDoctorList = focusCountDoctorService.list(query);
		int total = focusCountDoctorService.count(query);
		PageUtils pageUtils = new PageUtils(countDoctorList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("user:focusCountDoctor:add")
	String add(){
	    return "user/focusCountDoctor/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("user:focusCountDoctor:edit")
	String edit(@PathVariable("id") String id,Model model){
		FocusCountDoctorDO focusCountDoctor = focusCountDoctorService.get(id);
		model.addAttribute("focusCountDoctor", focusCountDoctor);
	    return "user/focusCountDoctor/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("user:focusCountDoctor:add")
	public R save( FocusCountDoctorDO focusCountDoctor){
		if(focusCountDoctorService.save(focusCountDoctor)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("user:focusCountDoctor:edit")
	public R update( FocusCountDoctorDO focusCountDoctor){
		focusCountDoctorService.update(focusCountDoctor);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("user:focusCountDoctor:remove")
	public R remove( String id){
		if(focusCountDoctorService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("user:focusCountDoctor:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		focusCountDoctorService.batchRemove(ids);
		return R.ok();
	}
	
}
