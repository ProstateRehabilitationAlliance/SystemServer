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

import com.prostate.base.domain.NationDO;
import com.prostate.base.service.NationService;
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
@RequestMapping("/base/nation")
public class NationController {
	@Autowired
	private NationService nationService;
	
	@GetMapping()
	@RequiresPermissions("base:nation:nation")
	String Nation(){
	    return "base/nation/nation";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:nation:nation")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<NationDO> nationList = nationService.list(query);
		int total = nationService.count(query);
		PageUtils pageUtils = new PageUtils(nationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:nation:add")
	String add(){
	    return "base/nation/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:nation:edit")
	String edit(@PathVariable("id") String id,Model model){
		NationDO nation = nationService.get(id);
		model.addAttribute("nation", nation);
	    return "base/nation/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:nation:add")
	public R save( NationDO nation){
		if(nationService.save(nation)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:nation:edit")
	public R update( NationDO nation){
		nationService.update(nation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:nation:remove")
	public R remove( String id){
		if(nationService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:nation:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		nationService.batchRemove(ids);
		return R.ok();
	}
	
}
