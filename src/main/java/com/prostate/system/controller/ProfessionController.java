package com.prostate.system.controller;

import com.prostate.system.entity.Profession;
import com.prostate.system.service.ProfessionSrvice;
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
 * @Description:  **职业管理**
 * @Date: Created in 10:25 2018/4/25
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController extends BaseController{



    @Autowired
    private ProfessionSrvice professionSrvice;

    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        //1.判断手机号是否可用
        if (type == 1) {
            List<Profession> list = professionSrvice.selectByProfessionName(param);
            //System.out.println(param);
            if (list==null||list.size()==0){

                resultMap.put("status",20000);
                resultMap.put("msg","OK,数据可用");
                resultMap.put("data",true);
            }else {
                System.out.println(list);
                resultMap.put("status",20001);
                resultMap.put("msg","数据不可用");
                resultMap.put("data",false);
            }
        }else{
            resultMap.put("status",20002);
            resultMap.put("msg","该数据暂时没有");
            resultMap.put("data",false);
        }
        return resultMap;
    }




    /**
     *    @Description:  1. 职业列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Map findByPage() {
        List<Profession> list=professionSrvice.findAll();
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
     *    @Params:   * @param null
     */


    @RequestMapping(value = "/addprofession",method = RequestMethod.POST)
    public Map addprofession(Profession profession) {

        List<Profession> list = professionSrvice.selectByProfessionName(profession.getProfessionName());
        if (list==null||list.size()==0){
            if (UserTokenManager.getToken()!=null){
                profession.setCreateUser(UserTokenManager.getToken().getId());
                profession.setDeleteUser(UserTokenManager.getToken().getId());
            }
            profession.setCreateTime(new Date());
            profession.setDeleteTime(new Date());
            profession.setDelFlag("0");
            int result=professionSrvice.insertSelective(profession);
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
            resultMap.put("msg","数据不可用");
            resultMap.put("data",false);
        }
        return resultMap;
    }

    /**
     *    @Description:  3. 职业修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */


    @RequestMapping(value = "/updprofession",method = RequestMethod.POST)
    public Map updprofession(Profession profession) {

        Profession profession01= professionSrvice.selectById(profession.getId());
        if (profession01!=null){
            if (UserTokenManager.getToken()!=null){
                profession.setUpdateUser(UserTokenManager.getToken().getId());
                profession.setDeleteUser(UserTokenManager.getToken().getId());

            }
            profession.setDeleteTime(new Date());
            profession.setUpdateTime(new Date());
            profession.setDelFlag("1");
            int result=professionSrvice.updateSelective(profession);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","职业修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","职业修改失败");
                resultMap.put("data",false);
            }
        }else {
            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);
        }
        return resultMap;

    }


    /**
     *    @Description:  4. 职业删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delprofession",method = RequestMethod.POST)
    public Map delprofession(@RequestParam String id) {

        Profession profession= professionSrvice.selectById(id);
        if (profession!=null){
            if (UserTokenManager.getToken()!=null){
                profession.setUpdateUser(UserTokenManager.getToken().getId());
                profession.setDeleteUser(UserTokenManager.getToken().getId());

            }
            profession.setDeleteTime(new Date());
            profession.setUpdateTime(new Date());
            profession.setDelFlag("1");
            int result=professionSrvice.updateSelective(profession);
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
