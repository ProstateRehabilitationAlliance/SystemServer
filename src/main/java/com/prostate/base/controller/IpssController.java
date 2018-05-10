package com.prostate.base.controller;

import java.util.List;
import java.util.Map;

import com.prostate.common.utils.ShiroUtils;
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

import com.prostate.base.domain.IpssDO;
import com.prostate.base.service.IpssService;
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
@RequestMapping("/base/ipss")
public class IpssController {
	@Autowired
	private IpssService ipssService;
	
	@GetMapping()
	@RequiresPermissions("base:ipss:ipss")
	String Ipss(){
	    return "base/ipss/ipss";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:ipss:ipss")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IpssDO> ipssList = ipssService.list(query);
		int total = ipssService.count(query);
		PageUtils pageUtils = new PageUtils(ipssList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:ipss:add")
	String add(){
	    return "base/ipss/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:ipss:edit")
	String edit(@PathVariable("id") String id,Model model){
		IpssDO ipss = ipssService.get(id);
		model.addAttribute("ipss", ipss);
	    return "base/ipss/edit";
	}
	
	/**
	 * 保存  增
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:ipss:add")
	public R save( IpssDO ipss){
		if(ipssService.save(ipss)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:ipss:edit")
	public R update( IpssDO ipss){
		ipssService.update(ipss);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:ipss:remove")
	public R remove( String id){
		if(ipssService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:ipss:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		ipssService.batchRemove(ids);
		return R.ok();
	}
	
}
