package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.Hospital;
import com.prostate.system.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prostate.system.shiro.UserTokenManager;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 13:09
 * @Todo:医院管理控制
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController extends  BaseController{

    @Autowired
    private HospitalService hospitalService;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/25 9:42
     * @todo: 展示医院信息列表
     * @param:   * @param null
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllDrug(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Hospital> anamnesisAllergyDrugs = hospitalService.selectAll();
        if (anamnesisAllergyDrugs.isEmpty()){
            resultMap.put("msg","没有医院信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到医院信息");
            resultMap.put("data",anamnesisAllergyDrugs);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   医院对象
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertDrug(Hospital hospital) {
        //先检查是否存在,然后再添加
        List<Hospital> hospitals = hospitalService.selectByName(hospital.getHospitalName());
        if (hospitals.isEmpty()){
            hospital.setCreateUser(UserTokenManager.getToken().getId());
            int r = hospitalService.insertSelective(hospital);
            if (r == 0){
                resultMap.put("msg","插入医院信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功插入医院信息");
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
     * @todo: 修改医院信息
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateDrug(Hospital hospital) {
        hospital.setUpdateUser(UserTokenManager.getToken().getId());
        int r = hospitalService.updateSelective(hospital);
        if (r == 0){
            resultMap.put("msg","修改医院信息失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功修改医院信息");
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
        Hospital hospital = hospitalService.selectById(id);
        if(hospital != null){
            hospital.setDeleteUser(UserTokenManager.getToken().getId());
            hospital.setDelFlag("1");
            int r = hospitalService.updateSelective(hospital);
            if (r == 0){
                resultMap.put("msg","删除医院信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除医院信息成功");
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("msg","20004");
            resultMap.put("status","这条信息不存在,可能之前已经删除了");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:50
     * @todo: 根据名字查询
     * @param:   * @param null
     */
    @GetMapping("/selectbyname")
    public  Map<String, Object> selectDrugByName(String hospitalName) {
        List<Hospital> hospitals = hospitalService.selectByName(hospitalName);
        if (hospitals.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",hospitals.get(0));
        }
        return resultMap;
    }
}
