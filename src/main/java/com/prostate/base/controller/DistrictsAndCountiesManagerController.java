package com.prostate.base.controller;

import com.prostate.base.domain.CityDO;
import com.prostate.base.domain.GroupID;
import com.prostate.base.domain.GroupWithoutID;
import com.prostate.base.service.DistrictsAndCountiesManagerService;
import com.prostate.common.annotation.Log;
import com.prostate.common.config.Constant;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.*;
import com.prostate.system.domain.DeptDO;
import com.prostate.system.domain.RoleDO;
import com.prostate.system.domain.UserDO;
import com.prostate.system.service.RoleService;
import com.prostate.system.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:    区县的管理增删查改
 * @Date: Created in 10:44 2018/5/14
 */
@Controller
@RequestMapping("/base/districtsAndCountiesManager")
public class DistrictsAndCountiesManagerController {

    private String prefix="base/districtsAndCountiesManager";
    @Autowired
    private DistrictsAndCountiesManagerService districtsAndCountiesManagerService;
    @Autowired
    private RoleService roleService;

    @RequiresPermissions("base:districtsAndCountiesManager:districtsAndCountiesManager")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/districtsAndCountiesManager";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<CityDO> cityDOList = districtsAndCountiesManagerService.list(query);
        int total = districtsAndCountiesManagerService.count(query);
        PageUtils pageUtil = new PageUtils(cityDOList, total);
        return pageUtil;
    }

    @RequiresPermissions("base:districtsAndCountiesManager:add")
    @Log("添加区县")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleDO> roles = roleService.list();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

    @RequiresPermissions("base:districtsAndCountiesManager:edit")
    @Log("编辑区县")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") String id) {
        CityDO cityDO = districtsAndCountiesManagerService.get(id);
        model.addAttribute("cityDO", cityDO);
        CityDO city = districtsAndCountiesManagerService.get(cityDO.getParentCityId());
        model.addAttribute("city",city);
        return prefix+"/edit";
    }

    @RequiresPermissions("base:districtsAndCountiesManager:add")
    @Log("保存区县")
    @PostMapping("/save")
    @ResponseBody
    R save( @Validated(GroupWithoutID.class) CityDO cityDO) {

        if (districtsAndCountiesManagerService.get(cityDO.getParentCityId()).getCityType().equalsIgnoreCase("0")){
            cityDO.setCityType("1");
        }else if(districtsAndCountiesManagerService.get(cityDO.getParentCityId()).getCityType().equalsIgnoreCase("1")){
            cityDO.setCityType("2");
        }else if(districtsAndCountiesManagerService.get(cityDO.getParentCityId()).getCityType().equalsIgnoreCase("2")){
            cityDO.setCityType("3");
        }

        if (districtsAndCountiesManagerService.listByName(cityDO.getCityName()).size()==0){
            cityDO.setCreateUser(ShiroUtils.getUserId().toString());
            cityDO.setUpdateTime(new Date());
            cityDO.setUpdateUser(ShiroUtils.getUserId().toString());
            if(districtsAndCountiesManagerService.save(cityDO)>0){
                return R.ok();
            }

        }
        return R.error(20001,"该区县名已经存在");


    }

    @RequiresPermissions("base:districtsAndCountiesManager:edit")
    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update( @Validated({GroupID.class,GroupWithoutID.class})CityDO cityDO) {


        CityDO cityDO1=districtsAndCountiesManagerService.get(cityDO.getId());
        if (!cityDO1.getCityName().equalsIgnoreCase(cityDO.getCityName())){
            if (districtsAndCountiesManagerService.listByName(cityDO.getCityName()).size()>0){
                return R.error(20001,"该区县名已经存在");
            }
        }

        cityDO.setUpdateUser(ShiroUtils.getUserId().toString());
        cityDO.setUpdateTime(new Date());
        if (districtsAndCountiesManagerService.update(cityDO)>0){
            return R.ok();
        }else {
            return R.error();
        }

    }


    @RequiresPermissions("base:districtsAndCountiesManager:edit")
    @Log("更新用户")
    @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(UserDO user) {
        return R.error();
    }


    @RequiresPermissions("base:districtsAndCountiesManager:remove")
    @Log("删除用户")
    @PostMapping("/remove")
    @ResponseBody
    R remove(String id) {

        CityDO cityDO =districtsAndCountiesManagerService.get(id);
        cityDO.setDeleteTime(new Date());
        cityDO.setDeleteUser(ShiroUtils.getUserId().toString());
        cityDO.setDelFlag("1");
        if (districtsAndCountiesManagerService.update(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("base:districtsAndCountiesManager:batchRemove")
    @Log("批量删除用户")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") String[] ids) {
        for (String id:ids){
            CityDO cityDO=districtsAndCountiesManagerService.get(id);
            cityDO.setId(id);
            cityDO.setDeleteUser(ShiroUtils.getUserId().toString());
            cityDO.setDeleteTime(new Date());
            cityDO.setDelFlag("1");
            districtsAndCountiesManagerService.update(cityDO);
        }

        return R.ok();
    }



    @RequiresPermissions("sys:user:resetPwd")
    @Log("请求更改用户密码")
    @GetMapping("/resetPwd/{id}")
    String resetPwd(@PathVariable("id") Long userId, Model model) {

        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        model.addAttribute("user", userDO);
        return prefix + "/reset_pwd";
    }


    @GetMapping("/tree")
    @ResponseBody
    public Tree<CityDO> tree() {
        Tree<CityDO> tree = new Tree<CityDO>();
       tree = districtsAndCountiesManagerService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return  prefix + "/districtsAndCountiesManagerTree";
    }




}
