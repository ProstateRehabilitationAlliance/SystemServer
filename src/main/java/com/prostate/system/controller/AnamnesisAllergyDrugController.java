package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.AnamnesisAllergyDrug;
import com.prostate.system.service.AnamnesisAllergyDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prostate.system.shiro.UserTokenManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 8:57
 * @Todo:  过敏药品管理
 */
@RestController
@RequestMapping("/drug/allergy")
public class AnamnesisAllergyDrugController extends BaseController {

    @Autowired
    private AnamnesisAllergyDrugService anamnesisAllergyDrugService;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/25 9:42
     * @todo: 展示药品信息列表
     * @param:   * @param null
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllDrug(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<AnamnesisAllergyDrug> anamnesisAllergyDrugs = anamnesisAllergyDrugService.selectAll();
        System.out.println(".................."+anamnesisAllergyDrugs);
        if (anamnesisAllergyDrugs.isEmpty()){
            resultMap.put("msg","没有药品信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到药品信息");
            resultMap.put("data",anamnesisAllergyDrugs);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   药品名称和编号,权重
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertDrug(AnamnesisAllergyDrug anamnesisAllergyDrug) {
        //先检查是否存在,然后再添加
        List<AnamnesisAllergyDrug> anamnesisAllergyDrugs =
                anamnesisAllergyDrugService.selectByName(anamnesisAllergyDrug.getAllergyDrugName());
        if (anamnesisAllergyDrugs.isEmpty()){
            anamnesisAllergyDrug.setCreateUser(UserTokenManager.getToken().getId());
            int r = anamnesisAllergyDrugService.insertSelective(anamnesisAllergyDrug);
            if (r == 0){
                resultMap.put("msg","插入药品信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功插入药品信息");
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
     * @todo: 修改药品信息
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateDrug(AnamnesisAllergyDrug anamnesisAllergyDrug) {
        anamnesisAllergyDrug.setUpdateUser(UserTokenManager.getToken().getId());
        int r = anamnesisAllergyDrugService.updateSelective(anamnesisAllergyDrug);
        if (r == 0){
            resultMap.put("msg","修改过敏药品信息失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功修改过敏药品信息");
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
        AnamnesisAllergyDrug anamnesisAllergyDrug = anamnesisAllergyDrugService.selectById(id);
        if(anamnesisAllergyDrug != null){
            anamnesisAllergyDrug.setDeleteUser(UserTokenManager.getToken().getId());
            anamnesisAllergyDrug.setDelFlag("1");
            int r = anamnesisAllergyDrugService.updateSelective(anamnesisAllergyDrug);
            if (r == 0){
                resultMap.put("msg","删除药品信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除药品信息成功");
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
    public  Map<String, Object> selectDrugByName(String allergyDrugName) {
        List<AnamnesisAllergyDrug> anamnesisAllergyDrugs = anamnesisAllergyDrugService.selectByName(allergyDrugName);
        if (anamnesisAllergyDrugs.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",anamnesisAllergyDrugs.get(0));
        }
        return resultMap;
    }
}
