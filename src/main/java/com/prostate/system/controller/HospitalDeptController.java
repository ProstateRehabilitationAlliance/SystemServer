package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.HospitalDept;
import com.prostate.system.service.HospitalDeptService;
import com.prostate.system.shiro.UserTokenManager;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/25 17:41
 * @Todo:
 */
@RestController
@RequestMapping("/hospital/dept")
public class HospitalDeptController extends  BaseController {

    @Autowired
    private HospitalDeptService hospitalDeptService;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/25 9:42
     * @todo: 展示医院科室信息列表
     * @param:   * @param null
     */
    @GetMapping("/list")
    public  Map<String, Object> getAllHospitalDept(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<HospitalDept> hospitalDepts  = hospitalDeptService.selectAll();
        if (hospitalDepts.isEmpty()){
            resultMap.put("msg","没有医院科室信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到医院科室信息");
            resultMap.put("data",hospitalDepts);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 17:48
     * @todo: 增加记录
     * @param:   医院科室对象
     */
    @PostMapping("/insert")
    public  Map<String, Object> insertHospitalDept(HospitalDept hospitalDept) {
        //先检查是否存在,然后再添加
       List<HospitalDept>  deptS = hospitalDeptService.selectByHospitalIDAndDeptID(
               hospitalDept.getHospitalId(),hospitalDept.getDeptId());
      if (deptS.isEmpty()){
            hospitalDept.setCreateUser(UserTokenManager.getToken().getId());
            int r = hospitalDeptService.insertSelective(hospitalDept);
            if (r == 0){
                resultMap.put("msg","插入医院科室信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功插入医院科室信息");
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
     * @todo: 修改医院科室信息
     * @param:   * @param null
     */
    @PostMapping("/update")
    public  Map<String, Object> updateHospitalDept(HospitalDept hospitalDept) {
        //先检查是否存在,然后再添加
        List<HospitalDept>  deptS = hospitalDeptService.selectByHospitalIDAndDeptID(
                hospitalDept.getHospitalId(),hospitalDept.getDeptId());
        if (deptS.isEmpty()){
            hospitalDept.setUpdateUser(UserTokenManager.getToken().getId());
            int r = hospitalDeptService.updateSelective(hospitalDept);
            if (r == 0){
                resultMap.put("msg","修改医院科室信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","成功修改医院科室信息");
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
    public  Map<String, Object> deleteHospitalDept(String id) {
        HospitalDept hospital = hospitalDeptService.selectById(id);
        if(hospital != null){
            hospital.setDeleteUser(UserTokenManager.getToken().getId());
            hospital.setDelFlag("1");
            int r = hospitalDeptService.updateSelective(hospital);
            if (r == 0){
                resultMap.put("msg","删除医院科室信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除医院科室信息成功");
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
     * @todo: 根据id查询
     * @param:
     */
    @GetMapping("/selectbyid")
    public  Map<String, Object> selectHospitalDeptByID(String id) {
        HospitalDept hospital = hospitalDeptService.selectById(id);
        if (hospital == null){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",hospital);
        }
        return resultMap;
    }
}
