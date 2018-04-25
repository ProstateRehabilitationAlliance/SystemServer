package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.HospitalType;
import com.prostate.system.service.HospitalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prostate.system.shiro.UserTokenManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 14:42
 * @Todo: 医院类型管理控制
 */
@RestController
@RequestMapping("/hospitaltype")
public class HospitalTypeController extends BaseController{

    @Autowired
    private HospitalTypeService hospitalTypeService;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/25 9:42
     * @todo: 展示医院类型信息列表
     * @param:   * @param null
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllDrug(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<HospitalType> hospitalTypes = hospitalTypeService.selectAll();
        if (hospitalTypes.isEmpty()){
            resultMap.put("msg","没有医院类型信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到医院类型信息");
            resultMap.put("data",hospitalTypes);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   类型
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertDrug(HospitalType hospitalType) {
        System.out.println("=========="+hospitalType.getHospitalTypeName()+hospitalType.getHospitalTypeNumber());
        //先检查是否存在,然后再添加
        List<HospitalType> hospitalTypes = hospitalTypeService.selectByName(hospitalType.getHospitalTypeName());
        if (hospitalTypes.isEmpty()){
            hospitalType.setCreateUser(UserTokenManager.getToken().getId());
            int r = hospitalTypeService.insertSelective(hospitalType);
            if (r == 0){
                resultMap.put("msg","插入失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功插入");
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
     * @todo: 修改医院类型信息
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateDrug(HospitalType hospitalType) {
        hospitalType.setUpdateUser(UserTokenManager.getToken().getId());
        int r = hospitalTypeService.updateSelective(hospitalType);
        if (r == 0){
            resultMap.put("msg","修改失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功修改");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:49
     * @todo: 删除记录
     * @param:   ID
     */
    @PostMapping("/delete")
    public  Map<String, Object> deleteDrug(String id) {
        HospitalType hospitalType = hospitalTypeService.selectById(id);
        if(hospitalType != null){
            hospitalType.setDeleteUser(UserTokenManager.getToken().getId());
            hospitalType.setDelFlag("1");
            int r = hospitalTypeService.updateSelective(hospitalType);
            if (r == 0){
                resultMap.put("msg","删除失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除成功");
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
     * @param:   名称
     */
    @GetMapping("/selectbyname")
    public  Map<String, Object> selectDrugByName(String hospitalTypeName) {
        List<HospitalType> hospitalTypes = hospitalTypeService.selectByName(hospitalTypeName);
        if (hospitalTypes.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",hospitalTypes.get(0));
        }
        return resultMap;
    }
}
