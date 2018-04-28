package com.prostate.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.AnamnesisType;
import com.prostate.system.entity.User;
import com.prostate.system.service.AnamnesisTypeService;
import com.prostate.system.shiro.UserTokenManager;
import org.apache.shiro.SecurityUtils;
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
 * @Description:   病史类型管理
 * @Date: Created in 15:48 2018/4/24
 */
@RestController
@RequestMapping("/anamnesistype")
public class AnamnesisTypeController extends BaseController {


    @Autowired
    private AnamnesisTypeService anamnesisTypeService;


    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam(value = "type",defaultValue = "1") Integer type){
        //1.判断数据是否可用
        if (type == 1) {
            List<AnamnesisType> list = anamnesisTypeService.selectByAnamnesisTypeName(param);
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
     *    @Description:  病史类型列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Map findByPage(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows) {

        Page<AnamnesisType> list= (Page<AnamnesisType>) anamnesisTypeService.findAll(page,rows);
        if(list==null|list.size()==0){


            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{

            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("rows",list);
            resultMap.put("total",list.getTotal());

        }
        System.out.println(list);
        return resultMap;
    }

    @RequestMapping(value = "/findAll01",method = RequestMethod.GET)
    public List findByPage01(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows) {
        List<AnamnesisType> list=anamnesisTypeService.findAll(page,rows);
        if(list==null|list.size()==0){

            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{
            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("data",list);
        }
        System.out.println(list);
        return list;
    }
    /**
     *    @Description:  病史类型添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/addanamnesistype",method = RequestMethod.POST)
    public Map addanamnesistype(AnamnesisType anamnesisType) {
        System.out.println(anamnesisType);
        List<AnamnesisType> list = anamnesisTypeService.selectByAnamnesisTypeName(anamnesisType.getAnamnesisTypeName());
        if (list==null||list.size()==0){
            if (UserTokenManager.getToken()!=null){
                anamnesisType.setCreateUser(UserTokenManager.getToken().getId());
                anamnesisType.setDeleteUser(UserTokenManager.getToken().getId());
            }
            anamnesisType.setCreateTime(new Date());
            anamnesisType.setDeleteTime(new Date());
            anamnesisType.setDelFlag("0");
            int result=anamnesisTypeService.insertSelective(anamnesisType);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","病史类型添加成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","病史类型添加失败");
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
     *    @Description:  病史类型修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/updanamnesistype",method = RequestMethod.POST)
    public Map updAnamnesisType(AnamnesisType anamnesisType) {

        AnamnesisType anamnesisType01= anamnesisTypeService.selectById(anamnesisType.getId());
        if (anamnesisType!=null){
            if (UserTokenManager.getToken()!=null){
                anamnesisType.setUpdateUser(UserTokenManager.getToken().getId());
                anamnesisType.setDeleteUser(UserTokenManager.getToken().getId());

            }
            anamnesisType.setDeleteTime(new Date());
            anamnesisType.setUpdateTime(new Date());
            anamnesisType.setDelFlag("1");
            int result=anamnesisTypeService.updateSelective(anamnesisType);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","病史类型修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","病史类型修改失败");
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
     *    @Description:  病史类型删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delanamnesistype",method = RequestMethod.POST)
    public Map delAnamnesisType(@RequestParam String id) {

        AnamnesisType anamnesisType= anamnesisTypeService.selectById(id);
        if (anamnesisType!=null){
            if (UserTokenManager.getToken()!=null){
                anamnesisType.setUpdateUser(UserTokenManager.getToken().getId());
                anamnesisType.setDeleteUser(UserTokenManager.getToken().getId());

            }
            anamnesisType.setDeleteTime(new Date());
            anamnesisType.setUpdateTime(new Date());
            anamnesisType.setDelFlag("1");
            int result=anamnesisTypeService.updateSelective(anamnesisType);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","病史类型删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","病史类型删除失败");
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
