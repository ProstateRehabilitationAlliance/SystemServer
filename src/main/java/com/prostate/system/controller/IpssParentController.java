package com.prostate.system.controller;

import com.prostate.system.entity.Ipss;
import com.prostate.system.service.IpssService;
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
 * @Description:      **IPSS评估管理**
 * @Date: Created in 10:15 2018/4/26
 */
@RestController
@RequestMapping("/ipssparent")
public class IpssParentController extends BaseController{

    @Autowired
    private IpssService ipssService;


    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkProvinceName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        //1.判断手机号是否可用
        if (type == 1) {
            //List<NihCpsi> list = nihCpsiService.selectByCityName(param);
            /*if (list==null||list.size()==0){
                resultMap.put("status",20000);
                resultMap.put("msg","OK,数据可用");
                resultMap.put("data",true);
            }else {
                System.out.println(list);
                resultMap.put("status",20001);
                resultMap.put("msg","数据不可用");
                resultMap.put("data",false);
            }*/
        }else{
            resultMap.put("status",20002);
            resultMap.put("msg","该数据暂时没有");
            resultMap.put("data",false);
        }
        return resultMap;
    }


    /**
     *    @Description:  1. IPSS评估项 题目列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map list() {
        List<Ipss> list=ipssService.findAll();

        if(list==null|list.size()==0){
            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{
            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("data",list);
        }
        /*String parentCityId="000011112222";
        List<Ipss> list=ipssService.findByParentId(parentCityId);
        if(list==null|list.size()==0){
            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{
            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("data",list);
        }*/
        return resultMap;
    }
    /**
     *    @Description:  2. IPSS评估项题目添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map addprovince(Ipss ipss) {
        if (UserTokenManager.getToken()!=null){
            ipss.setCreateUser(UserTokenManager.getToken().getId());
        }
        //ipss.setParentId("000011112222");
        ipss.setCreateTime(new Date());
        ipss.setDelFlag("0");
        int result=ipssService.insertSelective(ipss);
        if(result>0){
            resultMap.put("status",20000);
            resultMap.put("msg","IPSS评估项题目添加成功");
            resultMap.put("data",false);
        }else{
            resultMap.put("status",20005);
            resultMap.put("msg","NIPSS评估项题目添加失败");
            resultMap.put("data",false);
        }

        return resultMap;
    }


    /**
     *    @Description:  3. IPSS评估项题目修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(Ipss ipss) {

        Ipss ipss01= ipssService.selectById(ipss.getId());
        if (ipss01==null){

            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);

        }else{
            int result=ipssService.updateSelective(ipss);

            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","IPSS评估项题目修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","IPSS评估项题目修改失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


    /**
     *    @Description:  4. IPSS评估项题目删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delProvince(@RequestParam String id) {

        Ipss ipss = ipssService.selectById(id);
        if (ipss != null) {
            if (UserTokenManager.getToken() != null) {
                ipss.setDeleteUser(UserTokenManager.getToken().getId());
            }
            ipss.setDeleteTime(new Date());
            ipss.setDelFlag("1");
            int result = ipssService.updateSelective(ipss);
            if (result > 0) {
                resultMap.put("status", 20000);
                resultMap.put("msg", "IPSS评估项题目删除成功");
                resultMap.put("data", false);
            } else {
                resultMap.put("status", 20005);
                resultMap.put("msg", "IPSS评估项题目删除失败");
                resultMap.put("data", false);
            }
        } else {
            resultMap.put("status", 20005);
            resultMap.put("msg", "没有数据");
            resultMap.put("data", false);
        }
        return resultMap;
    }
}
