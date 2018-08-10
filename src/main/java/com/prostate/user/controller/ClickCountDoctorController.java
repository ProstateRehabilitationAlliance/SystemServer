package com.prostate.user.controller;

import java.util.List;
import java.util.Map;

import com.prostate.user.entity.ClickCountDoctorDO;
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

import com.prostate.user.service.ClickCountDoctorService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 医生之点击统计
 * 
 * @author ykbian
 * @email 1992lcg@163.com
 * @date 2018-08-10 15:50:11
 */
 
@Controller
@RequestMapping("/user/clickCountDoctor")
public class ClickCountDoctorController {
	@Autowired
	private ClickCountDoctorService clickCountDoctorService;
	
	@GetMapping()
	@RequiresPermissions("user:clickCountDoctor:clickCountDoctor")
	String CountDoctor(){
	    return "user/clickCountDoctor/clickCountDoctor";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("user:clickCountDoctor:clickCountDoctor")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ClickCountDoctorDO> countDoctorList = clickCountDoctorService.list(query);
		int total = clickCountDoctorService.count(query);
		PageUtils pageUtils = new PageUtils(countDoctorList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("user:clickCountDoctor:add")
	String add(){
	    return "user/clickCountDoctor/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("user:clickCountDoctor:edit")
	String edit(@PathVariable("id") String id,Model model){
		ClickCountDoctorDO clickCountDoctor = clickCountDoctorService.get(id);
		model.addAttribute("clickCountDoctor", clickCountDoctor);
	    return "user/clickCountDoctor/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("user:clickCountDoctor:add")
	public R save( ClickCountDoctorDO clickCountDoctor){
		if(clickCountDoctorService.save(clickCountDoctor)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("user:clickCountDoctor:edit")
	public R update( ClickCountDoctorDO clickCountDoctor){
		clickCountDoctorService.update(clickCountDoctor);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("user:clickCountDoctor:remove")
	public R remove( String id){
		if(clickCountDoctorService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("user:clickCountDoctor:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		clickCountDoctorService.batchRemove(ids);
		return R.ok();
	}
	
}
