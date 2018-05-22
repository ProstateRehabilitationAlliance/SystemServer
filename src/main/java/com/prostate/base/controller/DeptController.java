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

import com.prostate.base.domain.DeptDO;
import com.prostate.base.service.DeptService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 科室表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@GetMapping()
	@RequiresPermissions("base:dept:dept")
	String Dept(){
	    return "base/dept/dept";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:dept:dept")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DeptDO> deptList = deptService.list(query);
		int total = deptService.count(query);
		PageUtils pageUtils = new PageUtils(deptList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:dept:add")
	String add(){
	    return "base/dept/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:dept:edit")
	String edit(@PathVariable("id") String id,Model model){
		DeptDO dept = deptService.get(id);
		model.addAttribute("dept", dept);
	    return "base/dept/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:dept:add")
	public R save( DeptDO dept){
		if(deptService.save(dept)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:dept:edit")
	public R update( DeptDO dept){
		deptService.update(dept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:dept:remove")
	public R remove( String id){
		if(deptService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:dept:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		deptService.batchRemove(ids);
		return R.ok();
	}
	
}
