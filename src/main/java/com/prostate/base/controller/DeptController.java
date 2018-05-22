package com.prostate.base.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prostate.common.config.Constant;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.ShiroUtils;
import com.sun.tools.javac.tree.DCTree;
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
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<DeptDO> deptList = deptService.list(query);
//		int total = deptService.count(query);
//		PageUtils pageUtils = new PageUtils(deptList, total);
//		return pageUtils;
//	}
	public List<DeptDO> list() {
		Map<String, Object> query = new HashMap<>(16);
		List<DeptDO> sysDeptList = deptService.list(query);
		return sysDeptList;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("base:dept:add")
	String add(@PathVariable("pId") String pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId.equalsIgnoreCase("0")) {
			model.addAttribute("pName", "总部门");
		} else {
			model.addAttribute("pName", deptService.get(pId).getDeptName());
		}
		return  "base/dept/add";
	}

//	@GetMapping("/edit/{id}")
//	@RequiresPermissions("base:dept:edit")
//	String edit(@PathVariable("id") String id,Model model){
//		DeptDO dept = deptService.get(id);
//		model.addAttribute("dept", dept);
//	    return "base/dept/edit";
//	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:dept:edit")
	String edit(@PathVariable("id") String deptId, Model model) {
		DeptDO sysDept = deptService.get(deptId);
		model.addAttribute("dept", sysDept);
		if(Constant.DEPT_ROOT_ID2.equals(sysDept.getParentDeptId())) {
			model.addAttribute("parentDeptName", "无");
		}else {
			DeptDO parDept = deptService.get(sysDept.getParentDeptId());
			model.addAttribute("parentDeptName", parDept.getDeptName());
		}
		return  "base/dept/edit";
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:dept:add")
	public R save( DeptDO dept){
		DeptDO deptByName=  deptService.getByName(dept.getDeptName());
		DeptDO deptByNumber=  deptService.getByNumber(dept.getDeptNumber());
		if (deptByName == null && deptByNumber == null){
			dept.setCreateUser(ShiroUtils.getUserId().toString());
			dept.setCreateTime(new Date());
			dept.setDelFlag("0");
			if(deptService.save(dept)>0){
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
	@RequiresPermissions("base:dept:edit")
	public R update( DeptDO dept){
		DeptDO deptDO = deptService.get(dept.getId());
		System.out.println("======================");
		System.out.println(dept);
		if ( !deptDO.getDeptName().equalsIgnoreCase(dept.getDeptName())){
			if (deptService.getByName(dept.getDeptName()) != null){
				return R.error(20001,"名称重复");
			}
		}
		if ( !deptDO.getDeptNumber().equalsIgnoreCase(dept.getDeptNumber())){
			if (deptService.getByNumber(dept.getDeptNumber()) != null){
				return R.error(20001,"编号重复");
			}
		}
		dept.setUpdateUser(ShiroUtils.getUserId().toString());
		dept.setUpdateTime(new Date());
		deptService.update(dept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:dept:remove")
	public R remove(String id){
		DeptDO deptDO = deptService.get(id);
		deptDO.setDelFlag("1");
		deptDO.setDeleteUser(ShiroUtils.getUserId().toString());
		deptDO.setDeleteTime(new Date());
		if(deptService.update(deptDO)>0){
//		if(deptService.remove(id)>0){
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
		for (String id:ids) {
			DeptDO deptDO = deptService.get(id);
			deptDO.setDelFlag("1");
			deptDO.setDeleteUser(ShiroUtils.getUserId().toString());
			deptDO.setDeleteTime(new Date());
			deptService.update(deptDO);
		}
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = deptService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return   "base/dept/deptTree";
	}
}
