package com.prostate.system.controller;

import com.prostate.system.entity.Profession;
import com.prostate.system.service.ProfessionService;
import com.prostate.system.shiro.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:  职业管理
 * @Date: Created in 13:17 2018/4/24
 */


@RestController
@RequestMapping("/profession")
public class ProfessionController extends BaseController{


    @Autowired
    private ProfessionService professionService;


    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        //1.判断手机号是否可用

        return resultMap;
    }


    /**
     *    @Description:  1. 职业列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Map findByPage() {
        List<Profession> list=professionService.findAll();
        if(list==null|list.size()==0){

            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{
            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("data",list);
        }
        return resultMap;
    }
    /**
     *    @Description:  2. 职业添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param 传一个  parent_city_id  +   cityname
     */

    @RequestMapping(value = "/addprofession",method = RequestMethod.POST)
    public Map addprofession(Profession profession) {

        Profession profession01 = professionService.findByProfessionName(profession.getProfessionName());
        System.out.println(profession.getProfessionName()+"=="+profession01);
        if (profession01==null){
            profession.setDelFlag("0");
            //设置创建更新时间及日期
            if (UserTokenManager.getToken()!=null){
                profession.setUpdateUser(UserTokenManager.getToken().getId());
                profession.setUpdateUser(UserTokenManager.getToken().getId());
            }
            profession.setCreateTime(new Date());
            profession.setUpdateTime(new Date());
            int result=professionService.insertSelective(profession);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","职业添加成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","职业添加失败");
                resultMap.put("data",false);
            }
        }else {
            resultMap.put("status",20001);
            resultMap.put("msg","该职业数据已经存在");
            resultMap.put("data",false);
        }
        return resultMap;
    }

    /**
     *    @Description: 职业修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param 传一个  parent_city_id  +   cityname+id
     */

    @RequestMapping(value = "/updprofession",method = RequestMethod.POST)
    public Map updProfession(Profession profession) {

        Profession profession01= professionService.selectById(profession.getId());
        if (profession01==null){
            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);

        }else{
            profession.setId(profession01.getId());
            if (UserTokenManager.getToken()!=null){
                profession.setUpdateUser(UserTokenManager.getToken().getId());
            }
            profession.setUpdateTime(new Date());
            int result=professionService.updateSelective(profession);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","职业修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","职业修改失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


    /**
     *    @Description:  . 职业删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delprofession",method = RequestMethod.POST)
    public Map delProfession(@RequestParam String id) {

        Profession profession= professionService.selectById(id);
        if (profession!=null){
            if (UserTokenManager.getToken()!=null){
                profession.setUpdateUser(UserTokenManager.getToken().getId());
                profession.setDeleteUser(UserTokenManager.getToken().getId());

            }
            profession.setDeleteTime(new Date());
            profession.setUpdateTime(new Date());
            profession.setDelFlag("1");
            int result=professionService.updateSelective(profession);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","职业删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","职业删除失败");
                resultMap.put("data",false);
            }
        }else {
            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);
        }
        return resultMap;
    }




}
