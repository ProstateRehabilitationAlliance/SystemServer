package com.prostate.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.AnamnesisEatingDrug;
import com.prostate.system.service.AnamnesisEatingDrugService;
import com.prostate.system.shiro.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 17:30
 * @Todo:  正在服用的药品管理类
 */

@RestController
@RequestMapping("/drug/eat")
public class AnamnesisEatingDrugController extends  BaseController{

    @Autowired
    private AnamnesisEatingDrugService anamnesisEatingDrugService;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 列表展示
     * @param:   * @param null
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllDrug(@RequestParam("page") int pageNum,
                                           @RequestParam("rows") int pageSize) {
        Page<AnamnesisEatingDrug> anamnesisEatingDrugs=
                (Page<AnamnesisEatingDrug>) anamnesisEatingDrugService.selectAll(pageNum,pageSize);
        if (anamnesisEatingDrugs.isEmpty()){
            resultMap.put("msg","没有药品信息");
            resultMap.put("status",20007);
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","成功查询到药品信息");
            resultMap.put("status",20000);
            resultMap.put("rows",anamnesisEatingDrugs);
            resultMap.put("total",anamnesisEatingDrugs.getTotal());

        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   药品名称和编号
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertDrug(AnamnesisEatingDrug anamnesisEatingDrug) {
        //先检查是否存在,然后再添加
       List<AnamnesisEatingDrug> anamnesisEatingDrugs =
               anamnesisEatingDrugService.selectByName(anamnesisEatingDrug.getEatingDrugName());
       if (anamnesisEatingDrugs.isEmpty()){
           //暂时注释掉登录信息,方便编写
          // anamnesisEatingDrug.setCreateName(UserTokenManager.getToken().getId());
           anamnesisEatingDrug.setCreateName("张三");
           int r = anamnesisEatingDrugService.insertSelective(anamnesisEatingDrug);
           if (r == 0){
               resultMap.put("msg","插入药品信息失败");
               resultMap.put("status",20005);
               resultMap.put("data",null);
           }else {
               resultMap.put("msg","成功插入药品信息");
               resultMap.put("status",20000);
               resultMap.put("data",null);
           }
       }else {
           resultMap.put("msg","此信息已经存在");
           resultMap.put("status",20001);
           resultMap.put("data",null);
       }
         return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:49
     * @todo: 修改
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateDrug(AnamnesisEatingDrug anamnesisEatingDrug) {
        //先检查是否存在,然后再添加
        List<AnamnesisEatingDrug> anamnesisEatingDrugs =
                anamnesisEatingDrugService.selectByName(anamnesisEatingDrug.getEatingDrugName());
        if (anamnesisEatingDrugs.isEmpty()){
            //anamnesisEatingDrug.setUpdateName(UserTokenManager.getToken().getId());
            anamnesisEatingDrug.setUpdateName("马克思");
            int r = anamnesisEatingDrugService.updateSelective(anamnesisEatingDrug);
            if (r == 0){
                resultMap.put("msg","修改正在服用药品信息失败");
                resultMap.put("status",20005);
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","成功修改正在服用药品信息");
                resultMap.put("status",20000);
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
        AnamnesisEatingDrug anamnesisEatingDrug = anamnesisEatingDrugService.selectById(id);
        if(anamnesisEatingDrug != null){
            //anamnesisEatingDrug.setDeleteName(UserTokenManager.getToken().getId());
            anamnesisEatingDrug.setDeleteName("恩格斯");
            anamnesisEatingDrug.setDelFlag("1");
            int r = anamnesisEatingDrugService.updateSelective(anamnesisEatingDrug);
            if (r == 0){
                resultMap.put("msg","删除药品信息失败");
                resultMap.put("status",20005);
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","删除药品信息成功");
                resultMap.put("status",20000);
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("msg","这条信息不存在,可能之前已经删除了");
            resultMap.put("status",20004);
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
    public  Map<String, Object> selectDrugByName(String eatingDrugName) {
        List<AnamnesisEatingDrug> anamnesisEatingDrugs = anamnesisEatingDrugService.selectByName(eatingDrugName);
        if (anamnesisEatingDrugs.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status",20005);
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","查询成功");
            resultMap.put("status",20000);
            resultMap.put("data",anamnesisEatingDrugs.get(0));
        }
        return resultMap;
    }


}
