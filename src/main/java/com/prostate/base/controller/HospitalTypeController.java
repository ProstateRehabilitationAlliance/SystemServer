package com.prostate.base.controller;

import java.util.Date;
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

import com.prostate.base.domain.HospitalTypeDO;
import com.prostate.base.service.HospitalTypeService;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;

/**
 * 医院类型表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-07 14:02:35
 */
 
@Controller
@RequestMapping("/base/hospitalType")
public class HospitalTypeController {
	@Autowired
	private HospitalTypeService hospitalTypeService;
	
	@GetMapping()
	@RequiresPermissions("base:hospitalType:hospitalType")
	String HospitalType(){
	    return "base/hospitalType/hospitalType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:hospitalType:hospitalType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<HospitalTypeDO> hospitalTypeList = hospitalTypeService.list(query);
		int total = hospitalTypeService.count(query);
		PageUtils pageUtils = new PageUtils(hospitalTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:hospitalType:add")
	String add(){
	    return "base/hospitalType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:hospitalType:edit")
	String edit(@PathVariable("id") String id,Model model){
		HospitalTypeDO hospitalType = hospitalTypeService.get(id);
		model.addAttribute("hospitalType", hospitalType);
	    return "base/hospitalType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:hospitalType:add")
	public R save( HospitalTypeDO hospitalType){

		if (hospitalTypeService.listByName(hospitalType.getHospitalTypeName()).size()==0&&
				hospitalTypeService.listByNumber(hospitalType.getHospitalTypeNumber()).size()==0){
			hospitalType.setCreateUser(ShiroUtils.getUserId().toString());
			hospitalType.setUpdateTime(new Date());
			hospitalType.setUpdateUser(ShiroUtils.getUserId().toString());
			if(hospitalTypeService.save(hospitalType)>0){
				return R.ok();
			}
		}
		return R.error(20001,"该医院类型或者编号已经存在");



	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:hospitalType:edit")
	public R update( HospitalTypeDO hospitalType){

		HospitalTypeDO hospitalTypeDO=hospitalTypeService.get(hospitalType.getId());
		if (!hospitalTypeDO.getHospitalTypeName().equalsIgnoreCase(hospitalType.getHospitalTypeName())){
			if (hospitalTypeService.listByName(hospitalType.getHospitalTypeName()).size()>0){
				return R.error(20001,"该病史类型已经存在");
			}
		}
		if (!hospitalTypeDO.getHospitalTypeNumber().equalsIgnoreCase(hospitalType.getHospitalTypeNumber())){
			if (hospitalTypeService.listByNumber(hospitalType.getHospitalTypeNumber()).size()>0){
				return R.error(20001,"该病史类型编号已经存在");
			}
		}
		hospitalType.setUpdateUser(ShiroUtils.getUserId().toString());
		hospitalType.setUpdateTime(new Date());
		if (hospitalTypeService.update(hospitalType)>0){
			return R.ok();
		}else {
			return R.error();
		}

	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:hospitalType:remove")
	public R remove( String id){
		HospitalTypeDO hospitalTypeDO=new HospitalTypeDO();
		hospitalTypeDO.setId(id);
		hospitalTypeDO.setDeleteUser(ShiroUtils.getUserId().toString());
		hospitalTypeDO.setDeleteTime(new Date());
		hospitalTypeDO.setDelFlag("1");
		if(hospitalTypeService.update(hospitalTypeDO)>0){
			return R.ok();
		}
		return R.error();


	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:hospitalType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){

		for (String id:ids){
			HospitalTypeDO hospitalTypeDO=new HospitalTypeDO();
			hospitalTypeDO.setId(id);
			hospitalTypeDO.setDeleteUser(ShiroUtils.getUserId().toString());
			hospitalTypeDO.setDeleteTime(new Date());
			hospitalTypeDO.setDelFlag("1");
			hospitalTypeService.update(hospitalTypeDO);
		}

		//anamnesisTypeService.batchRemove(ids);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/getById")
	//@RequiresPermissions("base:hospitalType:hospitalType")
	public HospitalTypeDO getById(String id){
		return hospitalTypeService.get(id);
	}

}
