package com.prostate.system.controller;

import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.Nation;
import com.prostate.system.service.NationService;
import com.prostate.system.shiro.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/24 13:36
 * @Todo:民族管理控制器
 */

@RestController
@RequestMapping(value = "/nation")
public class NationController extends  BaseController{

    public static Map<String,Object> resultMap = new LinkedHashMap<>();

    @Autowired
    private NationService nationService;


    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 13:56
     * @todo: 展示民族信息列表
     * @param:  分页信息
     */
    @GetMapping(value = "/list")
    public  Map<String,Object>  queryAllNation(@RequestParam(defaultValue = "1") int pageNum,
                                                   @RequestParam(defaultValue = "10") int pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<Nation> nations = nationService.queryAllNation();
        System.out.println(nations.get(0));
        if (nations.isEmpty()){
            resultMap.put("msg","没有民族信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到民族信息");
            resultMap.put("data",nations);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 14:44
     * @todo: 新增民族信息
     * @param:   * @param null
     */
    @PostMapping(value = "/insert")
    public Map<String, Object> insertProfession(Nation nation) {
        //先判断,后修改
        List<Nation> nations =nationService.selectByNationName(nation.getNationName());
       // System.out.println("=============="+nations.get(0));
        if (nations.isEmpty()) {
            //获取当前登录用户信息并设置为profession的createID
            nation.setCreateUser(UserTokenManager.getToken().getId());
           int r = nationService.insertSelective(nation);
           if( r == 0){
               resultMap.put("msg","插入民族信息失败");
               resultMap.put("status","20005");
               resultMap.put("data",null);
           }else {
               resultMap.put("msg","20000");
               resultMap.put("status","成功插入民族信息");
               resultMap.put("data",null);
           }
        }else {
            resultMap.put("msg","20001");
            resultMap.put("status","此信息已经存在");
            resultMap.put("data",nations.get(0));
        }
         return resultMap;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 14:44
     * @todo: 修改民族信息
     * @param:   * @param null
     */
    @PostMapping(value = "/update")
    public  Map<String, Object> updateNation(Nation nation) {
        nation.setUpdateUser(UserTokenManager.getToken().getId());
       // profession.setCreateUser(UserTokenManager.getToken().getId());
        int r = nationService.updateSelective(nation);
        if (r == 0){
            resultMap.put("msg","修改民族信息失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功修改民族信息");
            resultMap.put("data",null);
        }
        return resultMap;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 14:45
     * @todo: 删除民族信息,假删除
     * @param:   * @param null
     */
    @PostMapping(value = "/delete")
    public  Map<String, Object> deleteNation(String nationID) {
        //int r = professionService.deleteById(professionID);
        String userid = UserTokenManager.getToken().getId();
        Nation nation = nationService.selectById(nationID);
        if(nation != null){
            nation.setDeleteUser(userid);
            nation.setDelFlag("1");
            int r = nationService.updateSelective(nation);
            if (r == 0){
                resultMap.put("msg","删除民族信息失败");
                resultMap.put("status","20005");
                resultMap.put("data",null);
            }else {
                resultMap.put("msg","20000");
                resultMap.put("status","删除民族成功");
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("msg","20004");
            resultMap.put("status","之前已经删除了");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/24 14:47
     * @todo: 根据民族名称查询民族信息
     * @param:   * @param null
     */
    @GetMapping("/selectbyname")
    public  Map<String, Object> selectByNationName(String nationName) {

        List<Nation> nations = nationService.selectByNationName(nationName);
        if (nations.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",nations.get(0));
        }
        return resultMap;
    }
}
