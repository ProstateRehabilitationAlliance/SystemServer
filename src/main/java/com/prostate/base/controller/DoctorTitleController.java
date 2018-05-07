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

import com.prostate.base.domain.DoctorTitleDO;
import com.prostate.base.service.DoctorTitleService;
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
@RequestMapping("/base/doctorTitle")
public class DoctorTitleController {
	@Autowired
	private DoctorTitleService doctorTitleService;
	
	@GetMapping()
	@RequiresPermissions("base:doctorTitle:doctorTitle")
	String DoctorTitle(){
	    return "base/doctorTitle/doctorTitle";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:doctorTitle:doctorTitle")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DoctorTitleDO> doctorTitleList = doctorTitleService.list(query);
		int total = doctorTitleService.count(query);
		PageUtils pageUtils = new PageUtils(doctorTitleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:doctorTitle:add")
	String add(){
	    return "base/doctorTitle/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:doctorTitle:edit")
	String edit(@PathVariable("id") String id,Model model){
		DoctorTitleDO doctorTitle = doctorTitleService.get(id);
		model.addAttribute("doctorTitle", doctorTitle);
	    return "base/doctorTitle/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:doctorTitle:add")
	public R save( DoctorTitleDO doctorTitle){
		if(doctorTitleService.save(doctorTitle)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:doctorTitle:edit")
	public R update( DoctorTitleDO doctorTitle){
		doctorTitleService.update(doctorTitle);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:doctorTitle:remove")
	public R remove( String id){
		if(doctorTitleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:doctorTitle:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		doctorTitleService.batchRemove(ids);
		return R.ok();
	}
	
}
