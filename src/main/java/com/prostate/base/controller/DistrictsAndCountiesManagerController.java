package com.prostate.base.controller;

import com.prostate.base.domain.CityDO;
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
        System.out.println("====<<<<<<<<<<" +id);
        CityDO cityDO = districtsAndCountiesManagerService.get(id);
        System.out.println("=======>"+cityDO);
        model.addAttribute("cityDO", cityDO);
        //List<RoleDO> roles = roleService.list(id);
        //model.addAttribute("roles", roles);
        return prefix+"/edit";
    }

    @RequiresPermissions("base:districtsAndCountiesManager:add")
    @Log("保存区县")
    @PostMapping("/save")
    @ResponseBody
    R save(CityDO cityDO) {
        /*if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
       // cityDO.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        if (districtsAndCountiesManagerService.save(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("base:districtsAndCountiesManager:edit")
    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update(CityDO cityDO) {
       /* if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (districtsAndCountiesManagerService.update(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
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
        System.out.println("******====>"+id);
        CityDO cityDO =new CityDO();
        cityDO.setDeleteTime(new Date());
        cityDO.setDeleteUser(ShiroUtils.getUserId().toString());
        cityDO.setDelFlag("0");
        if (districtsAndCountiesManagerService.update(cityDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("base:districtsAndCountiesManager:batchRemove")
    @Log("批量删除用户")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") String[] userIds) {
        /*if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        int r = districtsAndCountiesManagerService.batchRemove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }

   /* @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !districtsAndCountiesManagerService.exit(params);
    }*/

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
        return  prefix + "/userTree";
    }




}
