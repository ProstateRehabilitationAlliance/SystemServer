package com.prostate.system.controller;

import com.prostate.system.entity.NihCpsi;
import com.prostate.system.service.NihCpsiService;
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
 * @Description:  NC选项管理
 * @Date: Created in 17:37 2018/4/25
 */
@RestController
@RequestMapping("/ncson")
public class NihCpsiSonController extends BaseController{

    @Autowired
    private NihCpsiService nihCpsiService;


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
     *    @Description:  NC选项列表
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map list(String parentId) {
        List<NihCpsi> list=nihCpsiService.findByParentId(parentId);
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
     *    @Description:  NC选项添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map addprovince(NihCpsi nihCpsi) {
        if (UserTokenManager.getToken()!=null){
            nihCpsi.setCreateUser(UserTokenManager.getToken().getId());
        }
        nihCpsi.setCreateTime(new Date());
        nihCpsi.setDelFlag("0");
        int result=nihCpsiService.insertSelective(nihCpsi);
        if(result>0){
            resultMap.put("status",20000);
            resultMap.put("msg","NC选项添加成功");
            resultMap.put("data",false);
        }else{
            resultMap.put("status",20005);
            resultMap.put("msg","NC选项添加失败");
            resultMap.put("data",false);
        }

        return resultMap;
    }

    /**
     *    @Description:  NC选项修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(NihCpsi nihCpsi) {

        NihCpsi nihCpsi01= nihCpsiService.selectById(nihCpsi.getId());
        if (nihCpsi01==null){

            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);

        }else{
            int result=nihCpsiService.updateSelective(nihCpsi);

            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","NC选项成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","NC选项失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


    /**
     *    @Description:  NC选项删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delProvince(@RequestParam String id) {

        NihCpsi nihCpsi = nihCpsiService.selectById(id);
        if (nihCpsi != null) {
            if (UserTokenManager.getToken() != null) {
                nihCpsi.setDeleteUser(UserTokenManager.getToken().getId());
            }
            nihCpsi.setDeleteTime(new Date());
            nihCpsi.setDelFlag("1");
            int result = nihCpsiService.updateSelective(nihCpsi);
            if (result > 0) {
                resultMap.put("status", 20000);
                resultMap.put("msg", "NC选项删除成功");
                resultMap.put("data", false);
            } else {
                resultMap.put("status", 20005);
                resultMap.put("msg", "NC选项删除失败");
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
