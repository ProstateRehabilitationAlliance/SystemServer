package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.BloodGroup;
import com.prostate.system.service.BloodGroupServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prostate.system.shiro.UserTokenManager;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/26 11:36
 * @Todo:  血型管理
 */

@RestController
@RequestMapping("/bloodgroup")
public class BloodGroupController   extends  BaseController{

    @Autowired
    private BloodGroupServcie bloodGroupServcie;
    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/25 9:42
     * @todo: 展示血型信息列表
     * @param:
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllDrug(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<BloodGroup> bloodGroups = bloodGroupServcie.selectAll();
        if (bloodGroups.isEmpty()){
            resultMap.put("msg","没有血型信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到血型信息");
            resultMap.put("data",bloodGroups);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   血型名称和编号,权重
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertDrug(BloodGroup bloodGroup) {
        //先检查是否存在,然后再添加
        List<BloodGroup> bloodGroupName = bloodGroupServcie.selectByName(bloodGroup.getBloodGroupName());
        List<BloodGroup> bloodGroupNumber = bloodGroupServcie.selectByNumber(bloodGroup.getBloodGroupNumber());
        // 名称和编号都不重复的话就能提交信息
        if ( !bloodGroupName.isEmpty() || !bloodGroupNumber.isEmpty()){
            resultMap.put("msg","20001");
            resultMap.put("status","名称或者编号重复");
            resultMap.put("data",null);
        }else {
            bloodGroup.setCreateUser(UserTokenManager.getToken().getId());
            int r = bloodGroupServcie.insertSelective(bloodGroup);
            if (r == 0){
                resultMap.put("msg","插入血型信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功插入血型信息");
                resultMap.put("data",null);
            }
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:49
     * @todo: 修改血型信息
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateDrug(BloodGroup bloodGroup) {
        //先检查是否存在,然后再添加
        List<BloodGroup> bloodGroupName = bloodGroupServcie.selectByName(bloodGroup.getBloodGroupName());
        List<BloodGroup> bloodGroupNumber = bloodGroupServcie.selectByNumber(bloodGroup.getBloodGroupNumber());
        // 名称和编号都冲突的话不能提交
        if (bloodGroupName.isEmpty() && bloodGroupNumber.isEmpty()){
            bloodGroup.setUpdateUser(UserTokenManager.getToken().getId());
            int r = bloodGroupServcie.updateSelective(bloodGroup);
            if (r == 0){
                resultMap.put("msg","修改血型失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功修改血型信息");
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("msg","20001");
            resultMap.put("status","此信息已经存在");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:49
     * @todo: 删除记录
     * @param:   * @param null
     */
    @PostMapping("/delete")
    public  Map<String, Object> deleteDrug(String id) {
        BloodGroup bloodGroup = bloodGroupServcie.selectById(id);
        if(bloodGroup != null){
            bloodGroup.setDeleteUser(UserTokenManager.getToken().getId());
            bloodGroup.setDelFlag("1");
            int r = bloodGroupServcie.updateSelective(bloodGroup);
            if (r == 0){
                resultMap.put("msg","删除血型失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除血型成功");
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("msg","20004");
            resultMap.put("status","这条信息不存在,可能之前已经删除了");
            resultMap.put("data",null);
        }
        return resultMap;
    }

}
