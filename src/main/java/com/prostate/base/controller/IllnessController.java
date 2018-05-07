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

import com.prostate.base.domain.IllnessDO;
import com.prostate.base.service.IllnessService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 疾病表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/illness")
public class IllnessController {
	@Autowired
	private IllnessService illnessService;
	
	@GetMapping()
	@RequiresPermissions("base:illness:illness")
	String Illness(){
	    return "base/illness/illness";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:illness:illness")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IllnessDO> illnessList = illnessService.list(query);
		int total = illnessService.count(query);
		PageUtils pageUtils = new PageUtils(illnessList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:illness:add")
	String add(){
	    return "base/illness/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:illness:edit")
	String edit(@PathVariable("id") String id,Model model){
		IllnessDO illness = illnessService.get(id);
		model.addAttribute("illness", illness);
	    return "base/illness/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:illness:add")
	public R save( IllnessDO illness){
		if(illnessService.save(illness)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:illness:edit")
	public R update( IllnessDO illness){
		illnessService.update(illness);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:illness:remove")
	public R remove( String id){
		if(illnessService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:illness:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		illnessService.batchRemove(ids);
		return R.ok();
	}
	
}
