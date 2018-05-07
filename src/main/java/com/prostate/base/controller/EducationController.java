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

import com.prostate.base.domain.EducationDO;
import com.prostate.base.service.EducationService;
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
@RequestMapping("/base/education")
public class EducationController {
	@Autowired
	private EducationService educationService;
	
	@GetMapping()
	@RequiresPermissions("base:education:education")
	String Education(){
	    return "base/education/education";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:education:education")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EducationDO> educationList = educationService.list(query);
		int total = educationService.count(query);
		PageUtils pageUtils = new PageUtils(educationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:education:add")
	String add(){
	    return "base/education/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:education:edit")
	String edit(@PathVariable("id") String id,Model model){
		EducationDO education = educationService.get(id);
		model.addAttribute("education", education);
	    return "base/education/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:education:add")
	public R save( EducationDO education){
		if(educationService.save(education)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:education:edit")
	public R update( EducationDO education){
		educationService.update(education);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:education:remove")
	public R remove( String id){
		if(educationService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:education:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		educationService.batchRemove(ids);
		return R.ok();
	}
	
}
