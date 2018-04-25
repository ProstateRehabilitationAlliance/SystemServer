package com.prostate.system.controller;

import com.prostate.system.entity.Illness;
import com.prostate.system.service.IllnessService;
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
 * @Description:   ICD疾病管理
 * @Date: Created in 13:50 2018/4/25
 */
@RestController
@RequestMapping("/illness")
public class IllnessController extends BaseController{



    @Autowired
    private IllnessService illnessService;

    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map check(@RequestParam("param") String param, @RequestParam(value = "type",defaultValue = "1") Integer type){
        //1.判断该类型是否可用
        if (type == 1) {
            List<Illness> list = illnessService.selectByIllnessName(param);
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
     *    @Description:  1. 疾病列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public Map findByPage() {
        List<Illness> list=illnessService.findAll();
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
     *    @Description:  2. 疾病添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/addillness",method = RequestMethod.POST)
    public Map addIllness(Illness illness) {

        List<Illness> list = illnessService.selectByIllnessName(illness.getIllnessName());
        if (list==null||list.size()==0){
            if (UserTokenManager.getToken()!=null){
                illness.setCreateUser(UserTokenManager.getToken().getId());
                illness.setUpdateUser(UserTokenManager.getToken().getId());
            }
            illness.setCreateTime(new Date());
            illness.setUpdateTime(new Date());
            illness.setDelFlag("0");
            int result=illnessService.insertSelective(illness);
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

    @RequestMapping(value = "/updillness",method = RequestMethod.POST)
    public Map updAnamnesisType(Illness illness) {

        Illness illness01= illnessService.selectById(illness.getId());
        if (illness01!=null){
            if (UserTokenManager.getToken()!=null){
                illness.setUpdateUser(UserTokenManager.getToken().getId());

            }
            illness.setUpdateTime(new Date());
            int result=illnessService.updateSelective(illness);
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
     *    @Description:  疾病类型删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delillness",method = RequestMethod.POST)
    public Map delAnamnesisType(@RequestParam String id) {

        Illness illness= illnessService.selectById(id);
        if (illness!=null){
            if (UserTokenManager.getToken()!=null){
                illness.setUpdateUser(UserTokenManager.getToken().getId());
                illness.setDeleteUser(UserTokenManager.getToken().getId());

            }
            illness.setDeleteTime(new Date());
            illness.setUpdateTime(new Date());
            illness.setDelFlag("1");
            int result=illnessService.updateSelective(illness);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","疾病删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","疾病删除失败");
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
