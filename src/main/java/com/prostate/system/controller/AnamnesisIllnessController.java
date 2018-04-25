package com.prostate.system.controller;

import com.prostate.system.entity.AnamnesisIllness;
import com.prostate.system.service.AnamnesisIllnessService;
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
 * @Description:  病史疾病管理
 * @Date: Created in 19:03 2018/4/24
 */
@RestController
@RequestMapping("/anamnesisIllness")
public class AnamnesisIllnessController extends BaseController{

        @Autowired
    private AnamnesisIllnessService anamnesisIllnessService;

    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        //1.判断手机号是否可用
        if (type == 1) {
            List<AnamnesisIllness> list = anamnesisIllnessService.selectByAnamnesisIllnessName(param);
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
    public Map findByPage() {
        List<AnamnesisIllness> list=anamnesisIllnessService.findAll();
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
     *    @Description:  病史类型添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/addanamnesistype",method = RequestMethod.POST)
    public Map addanamnesistype(AnamnesisIllness anamnesisIllness) {

        List<AnamnesisIllness> list = anamnesisIllnessService.selectByAnamnesisIllnessName(anamnesisIllness.getAnamnesisIllnessName());
        if (list==null||list.size()==0){
            if (UserTokenManager.getToken()!=null){
                anamnesisIllness.setCreateUser(UserTokenManager.getToken().getId());
                anamnesisIllness.setDeleteUser(UserTokenManager.getToken().getId());
            }
            anamnesisIllness.setCreateTime(new Date());
            anamnesisIllness.setDeleteTime(new Date());
            anamnesisIllness.setDelFlag("0");
            int result=anamnesisIllnessService.insertSelective(anamnesisIllness);
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
    public Map updAnamnesisType(AnamnesisIllness anamnesisIllness) {

        AnamnesisIllness anamnesisIllness01= anamnesisIllnessService.selectById(anamnesisIllness.getId());
        if (anamnesisIllness01!=null){
            if (UserTokenManager.getToken()!=null){
                anamnesisIllness.setUpdateUser(UserTokenManager.getToken().getId());
                anamnesisIllness.setDeleteUser(UserTokenManager.getToken().getId());

            }
            anamnesisIllness.setDeleteTime(new Date());
            anamnesisIllness.setUpdateTime(new Date());
            anamnesisIllness.setDelFlag("1");
            int result=anamnesisIllnessService.updateSelective(anamnesisIllness);
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

        AnamnesisIllness anamnesisIllness= anamnesisIllnessService.selectById(id);
        if (anamnesisIllness!=null){
            if (UserTokenManager.getToken()!=null){
                anamnesisIllness.setUpdateUser(UserTokenManager.getToken().getId());
                anamnesisIllness.setDeleteUser(UserTokenManager.getToken().getId());

            }
            anamnesisIllness.setDeleteTime(new Date());
            anamnesisIllness.setUpdateTime(new Date());
            anamnesisIllness.setDelFlag("1");
            int result=anamnesisIllnessService.updateSelective(anamnesisIllness);
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
