package com.prostate.base.controller;

import com.prostate.base.domain.CityDO;
import com.prostate.base.domain.ScaleDO;
import com.prostate.base.service.DistrictsAndCountiesManagerService;
import com.prostate.base.service.ScaleManagerService;
import com.prostate.common.annotation.Log;
import com.prostate.common.domain.Tree;
import com.prostate.common.utils.PageUtils;
import com.prostate.common.utils.Query;
import com.prostate.common.utils.R;
import com.prostate.common.utils.ShiroUtils;
import com.prostate.system.domain.RoleDO;
import com.prostate.system.domain.UserDO;
import com.prostate.system.service.RoleService;
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
 * @Description:    scale题库增删查改
 * @Date: Created in 10:44 2018/5/14
 */
@Controller
@RequestMapping("/base/scaleManager")
public class ScaleManagerController {

    private String prefix="base/scaleManager";
    @Autowired
    private ScaleManagerService scaleManagerService;
    @Autowired
    private RoleService roleService;

    @RequiresPermissions("base:scaleManager:scaleManager")
    @GetMapping("")
    String user(Model model) {

        System.out.println("++++++++++++++++++++1");
        return prefix + "/scaleManager";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        if(params.get("parentId")==null||params.get("parentId").equals("")){
            query.put("parentId","0");
        }
        List<ScaleDO> scaleDOList = scaleManagerService.list(query);

        int total = scaleManagerService.count(query);
        PageUtils pageUtil = new PageUtils(scaleDOList, total);
        return pageUtil;
    }

    @RequiresPermissions("base:scaleManager:add")
    @Log("添加区县")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleDO> roles = roleService.list();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

    @RequiresPermissions("base:scaleManager:edit")
    @Log("编辑区县")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") String id) {
        ScaleDO scaleDO = scaleManagerService.get(id);
        model.addAttribute("scaleDO", scaleDO);
        ScaleDO scale = scaleManagerService.get(scaleDO.getParentId());
        model.addAttribute("scale",scale);
        return prefix+"/edit";
    }

    @RequiresPermissions("base:scaleManager:add")
    @Log("保存区县")
    @PostMapping("/save")
    @ResponseBody
    R save(ScaleDO scaleDO) {

        ScaleDO scale=scaleManagerService.get(scaleDO.getParentId());
        if (scale!=null||scale.equals("")){
            if(scale.getScaleType().equalsIgnoreCase("a")||
                    scale.getScaleType().equalsIgnoreCase("b")||
                    scale.getScaleType().equalsIgnoreCase("c")){
                scaleDO.setScaleType("1");
            }else if (scale.getScaleType().equalsIgnoreCase("1")){
                scaleDO.setScaleType("0");
            }
        }

       // if (scaleManagerService.listByName(scaleDO.getCityName()).size()==0){
            scaleDO.setCreateUser(ShiroUtils.getUserId().toString());
           // scaleDO.setUpdateUser(ShiroUtils.getUserId().toString());
            if(scaleManagerService.save(scaleDO)>0){
                return R.ok();
            }

      //  }
        return R.error(20001,"该区县名已经存在");


    }

    @RequiresPermissions("base:scaleManager:edit")
    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update(ScaleDO scaleDO) {


        ScaleDO scale=scaleManagerService.get(scaleDO.getParentId());
        if (scale!=null||scale.equals("")){
            if(scale.getScaleType().equalsIgnoreCase("a")||
                    scale.getScaleType().equalsIgnoreCase("b")||
                    scale.getScaleType().equalsIgnoreCase("c")){
                scaleDO.setScaleType("1");
            }else if (scale.getScaleType().equalsIgnoreCase("1")){
                scaleDO.setScaleType("0");
            }
        }



       // if (!scale.getCityName().equalsIgnoreCase(scaleDO.getCityName())){
           // if (scaleManagerService.listByName(scaleDO.getCityName()).size()>0){
           //     return R.error(20001,"该区县名已经存在");
          //  }
      //  }

        //scaleDO.setUpdateUser(ShiroUtils.getUserId().toString());
       // scaleDO.setUpdateTime(new Date());
        if (scaleManagerService.update(scaleDO)>0){
            return R.ok();
        }else {
            return R.error();
        }

    }


    @RequiresPermissions("base:scaleManager:edit")
    @Log("更新用户")
    @PostMapping("/updatePeronal")
    @ResponseBody
    R updatePeronal(UserDO user) {
        return R.error();
    }


    @RequiresPermissions("base:scaleManager:remove")
    @Log("删除用户")
    @PostMapping("/remove")
    @ResponseBody
    R remove(String id) {

        ScaleDO scaleDO =scaleManagerService.get(id);
        scaleDO.setDeleteTime(new Date());
        scaleDO.setDeleteUser(ShiroUtils.getUserId().toString());
        scaleDO.setDelFlag("1");
        if (scaleManagerService.update(scaleDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("base:scaleManager:batchRemove")
    @Log("批量删除用户")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") String[] ids) {
        for (String id:ids){
            ScaleDO scaleDO=scaleManagerService.get(id);
            scaleDO.setId(id);
            scaleDO.setDeleteUser(ShiroUtils.getUserId().toString());
            scaleDO.setDeleteTime(new Date());
            scaleDO.setDelFlag("1");
            scaleManagerService.update(scaleDO);
        }

        return R.ok();
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
    public Tree<ScaleDO> tree() {
        Tree<ScaleDO> tree = new Tree<ScaleDO>();
       tree = scaleManagerService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return  prefix + "/scaleManagerTree";
    }




}
