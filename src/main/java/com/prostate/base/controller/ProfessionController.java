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

import com.prostate.base.domain.ProfessionDO;
import com.prostate.base.service.ProfessionService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:36
 */
 
@Controller
@RequestMapping("/base/profession")
public class ProfessionController {
	@Autowired
	private ProfessionService professionService;
	
	@GetMapping()
	@RequiresPermissions("base:profession:profession")
	String Profession(){
	    return "base/profession/profession";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:profession:profession")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProfessionDO> professionList = professionService.list(query);
		int total = professionService.count(query);
		PageUtils pageUtils = new PageUtils(professionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:profession:add")
	String add(){
	    return "base/profession/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:profession:edit")
	String edit(@PathVariable("id") String id,Model model){
		ProfessionDO profession = professionService.get(id);
		model.addAttribute("profession", profession);
	    return "base/profession/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:profession:add")
	public R save( ProfessionDO profession){
		if(professionService.save(profession)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:profession:edit")
	public R update( ProfessionDO profession){
		professionService.update(profession);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:profession:remove")
	public R remove( String id){
		if(professionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:profession:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		professionService.batchRemove(ids);
		return R.ok();
	}
	
}
