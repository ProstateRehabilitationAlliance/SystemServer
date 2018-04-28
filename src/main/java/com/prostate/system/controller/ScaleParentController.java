package com.prostate.system.controller;

import com.prostate.system.entity.Scale;
import com.prostate.system.service.ScaleService;
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
 * @Description:  量表管理
 * @Date: Created in 13:40 2018/4/28
 */
@RestController
@RequestMapping("/scaleparent")
public class ScaleParentController extends BaseController{
    @Autowired
    private ScaleService scaleServic;

    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        /*//1.判断手机号是否可用
        if (type == 1) {
            List<Scale> list = scaleServic.selectByCityName(param);
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
        }*/
        return resultMap;
    }



    /**
     *    @Description:  1. 量表项列表展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/list")
    public Map findByPage(@RequestParam(defaultValue ="0" ) Integer pageNum ,
                          @RequestParam(defaultValue = "10")  Integer pageSize
            , @RequestParam String parentId) {
        List<Scale> list=scaleServic.list(parentId);
        if(list==null|list.size()==0){

            resultMap.put("status",20007);
            resultMap.put("msg","没有找到相关数据数据");
            resultMap.put("data",false);

        }else{
            resultMap.put("status",20000);
            resultMap.put("msg","数据查询成功");
            resultMap.put("rows",list);
        }
        return resultMap;
    }


    /**
     *    @Description:  2. 量表项添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map addcity(Scale scale) {


        scale.setCreateTime(new Date());
            if (UserTokenManager.getToken()!=null){
                scale.setCreateUser(UserTokenManager.getToken().getId());
            }
        scale.setCreateTime(new Date());
        scale.setDelFlag("0");
            int result=scaleServic.insertSelective(scale);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","量表项录入成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","量表项录入失败");
                resultMap.put("data",false);
            }

        return resultMap;
    }

    /**
     *    @Description:  3. 量表项修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updcity(Scale scale) {

        Scale scale01= scaleServic.selectById(scale.getId());
        if (scale01==null){

            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);

        }else{

            scale.setCreateTime(new Date());
            if (UserTokenManager.getToken()!=null){
            }
            int result=scaleServic.updateSelective(scale);

            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","量表项修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","量表项修改失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


/*    *
     *    @Description:  4. 量表项删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     *    */


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delCity(@RequestParam String id) {

        Scale scale= scaleServic.selectById(id);
        if (scale!=null){
            if (UserTokenManager.getToken()!=null){
                scale.setDeleteUser(UserTokenManager.getToken().getId());
            }
            scale.setDeleteTime(new Date());
            scale.setDelFlag("1");
            int result=scaleServic.updateSelective(scale);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","量表项删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","量表项删除失败");
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
