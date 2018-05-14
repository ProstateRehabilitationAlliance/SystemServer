/*
package com.prostate.base.controller;

import com.prostate.base.domain.CityDO;
import com.prostate.base.service.ProvinceAndCityManageService;
import com.prostate.common.config.Constant;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 10:17 2018/5/14
 *//*

public class ProvinceAndCityManageController {

    private String prefix = "base/provinceAndCityManage";
    @Autowired
    private ProvinceAndCityManageService provinceAndCityManageService;

    @GetMapping()
    @RequiresPermissions("base:provinceAndCityManage:provinceAndCityManage")
    String dept() {
        return prefix + "/dept";
    }

    @ApiOperation(value="获取部门列表", notes="")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:sysDept:sysDept")
    public List<CityDO> list() {
        Map<String, Object> query = new HashMap<>(16);
        List<CityDO> sysDeptList = provinceAndCityManageService.list(query);
        return sysDeptList;
    }

    @GetMapping("/add/{pId}")
    @RequiresPermissions("system:sysDept:add")
    String add(@PathVariable("pId") Long pId, Model model) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "总部门");
        } else {
            model.addAttribute("pName", provinceAndCityManageService.get(pId).getName());
        }
        return  prefix + "/add";
    }

    @GetMapping("/edit/{deptId}")
    @RequiresPermissions("system:sysDept:edit")
    String edit(@PathVariable("deptId") Long deptId, Model model) {
        CityDO sysDept = provinceAndCityManageService.get(deptId);
        model.addAttribute("sysDept", sysDept);
        if(Constant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
            model.addAttribute("parentDeptName", "无");
        }else {
            CityDO parDept = provinceAndCityManageService.get(sysDept.getParentId());
            model.addAttribute("parentDeptName", parDept.getName());
        }
        return  prefix + "/edit";
    }

    */
/**
     * 保存
     *//*

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:sysDept:add")
    public R save(CityDO cityDO) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (provinceAndCityManageService.save(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    */
/**
     * 修改
     *//*

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:sysDept:edit")
    public R update(CityDO cityDO) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (provinceAndCityManageService.update(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    */
/**
     * 删除
     *//*

    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:sysDept:remove")
    public R remove(Long deptId) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", deptId);
        if(provinceAndCityManageService.count(map)>0) {
            return R.error(1, "包含下级部门,不允许修改");
        }
        if(provinceAndCityManageService.checkDeptHasUser(deptId)) {
            if (provinceAndCityManageService.remove(deptId) > 0) {
                return R.ok();
            }
        }else {
            return R.error(1, "部门包含用户,不允许修改");
        }
        return R.error();
    }

    */
/**
     * 删除
     *//*

    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:sysDept:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] deptIds) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        provinceAndCityManageService.batchRemove(deptIds);
        return R.ok();
    }

    @GetMapping("/tree")
    @ResponseBody
    public Tree<CityDO> tree() {
        Tree<CityDO> tree = new Tree<CityDO>();
        tree = provinceAndCityManageService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return  prefix + "/deptTree";
    }


}
*/
