package com.prostate.base.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.prostate.common.utils.ShiroUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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

import com.prostate.base.domain.AnamnesisAllergyDrugDO;
import com.prostate.base.service.AnamnesisAllergyDrugService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/anamnesisAllergyDrug")
public class AnamnesisAllergyDrugController {
	@Autowired
	private AnamnesisAllergyDrugService anamnesisAllergyDrugService;
	
	@GetMapping()
	@RequiresPermissions("base:anamnesisAllergyDrug:anamnesisAllergyDrug")
	String AnamnesisAllergyDrug(){
	    return "base/anamnesisAllergyDrug/anamnesisAllergyDrug";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:anamnesisAllergyDrug:anamnesisAllergyDrug")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AnamnesisAllergyDrugDO> anamnesisAllergyDrugList = anamnesisAllergyDrugService.list(query);
		int total = anamnesisAllergyDrugService.count(query);
		PageUtils pageUtils = new PageUtils(anamnesisAllergyDrugList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:anamnesisAllergyDrug:add")
	String add(){
	    return "base/anamnesisAllergyDrug/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:anamnesisAllergyDrug:edit")
	String edit(@PathVariable("id") String id,Model model){
		AnamnesisAllergyDrugDO anamnesisAllergyDrug = anamnesisAllergyDrugService.get(id);
		model.addAttribute("anamnesisAllergyDrug", anamnesisAllergyDrug);
	    return "base/anamnesisAllergyDrug/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:anamnesisAllergyDrug:add")
	public R save( AnamnesisAllergyDrugDO anamnesisAllergyDrug){
		if (anamnesisAllergyDrugService.getByName(anamnesisAllergyDrug.getAllergyDrugName()) == null
				&& anamnesisAllergyDrugService.getByNumber(anamnesisAllergyDrug.getAllergyDrugNumber()) == null){
			anamnesisAllergyDrug.setCreateTime(new Date());
			anamnesisAllergyDrug.setCreateUser(ShiroUtils.getUserId().toString());
			anamnesisAllergyDrug.setDelFlag("0");
			if(anamnesisAllergyDrugService.save(anamnesisAllergyDrug)>0){
				return R.ok();
			}
		}
		return R.error(20001,"名称或者编号重复");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:anamnesisAllergyDrug:edit")
	public R update( AnamnesisAllergyDrugDO anamnesisAllergyDrug){
		AnamnesisAllergyDrugDO anamnesisAllergyDrugById = anamnesisAllergyDrugService.get(anamnesisAllergyDrug.getId());
		if (!anamnesisAllergyDrugById.getAllergyDrugName().equalsIgnoreCase(anamnesisAllergyDrug.getAllergyDrugName())){
			if (anamnesisAllergyDrugService.getByName(anamnesisAllergyDrug.getAllergyDrugName()) != null){
				return R.error(20001,"名称重复");
			}
		}
		if (!anamnesisAllergyDrugById.getAllergyDrugNumber().equalsIgnoreCase(anamnesisAllergyDrug.getAllergyDrugNumber())){
			if (anamnesisAllergyDrugService.getByNumber(anamnesisAllergyDrug.getAllergyDrugNumber()) != null){
				return R.error(20001,"编号重复");
			}
		}
		anamnesisAllergyDrug.setUpdateTime(new Date());
		anamnesisAllergyDrug.setUpdateUser(ShiroUtils.getUserId().toString());
		anamnesisAllergyDrugService.update(anamnesisAllergyDrug);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisAllergyDrug:remove")
	public R remove( String id){
		AnamnesisAllergyDrugDO anamnesisAllergyDrugById = anamnesisAllergyDrugService.get(id);
		if (anamnesisAllergyDrugById == null){
			return  R.error(20004,"数据不存在");
		}
		anamnesisAllergyDrugById.setDelFlag("1");
		anamnesisAllergyDrugById.setDeleteTime(new Date());
		anamnesisAllergyDrugById.setDeleteUser(ShiroUtils.getUserId().toString());
		if (anamnesisAllergyDrugService.update(anamnesisAllergyDrugById) > 0){
			return R.ok();
		}
//		if(anamnesisAllergyDrugService.remove(id)>0){
//
//		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:anamnesisAllergyDrug:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		try {
			for (String id: ids) {
				AnamnesisAllergyDrugDO anamnesisAllergyDrugById = anamnesisAllergyDrugService.get(id);
				anamnesisAllergyDrugById.setDelFlag("1");
				anamnesisAllergyDrugById.setDeleteTime(new Date());
				anamnesisAllergyDrugById.setDeleteUser(ShiroUtils.getUserId().toString());
				anamnesisAllergyDrugService.update(anamnesisAllergyDrugById);
			}
		}catch (Exception E){
			System.out.println("有个id是空的，请检查数据库信息");
		}
		finally {
			return R.ok();
		}
		//anamnesisAllergyDrugService.batchRemove(ids);

	}
	
}
