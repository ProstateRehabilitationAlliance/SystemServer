package com.prostate.system.controller;

import com.prostate.system.entity.City;
import com.prostate.system.service.CityService;
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
 * @Description:   区/县级地区管理**
 * @Date: Created in 14:23 2018/4/23
 */
@RestController()
@RequestMapping("/counties")
public class CountiesController extends BaseController{


    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @Autowired
    private CityService cityService;
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkCityName(@RequestParam("param") String param, @RequestParam("type") Integer type){
        //1.判断手机号是否可用
        if (type == 1) {
            List<City> list = cityService.selectByCityName(param);
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
     *    @Description:  1.1 区/县级地区列表 展示
     *    @Date:  14:43  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/findbypage")
    public Map findByPage(@RequestParam(defaultValue ="0" ) Integer pageNum ,
                          @RequestParam(defaultValue = "10")  Integer pageSize
            , @RequestParam String parentCityId) {
        List<City> list=cityService.findByPage(parentCityId);
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
     *    @Description:  1.2 区/县级地区添加
     *    @Date:  16:11  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/addcounties",method = RequestMethod.POST)
    public Map addcounties(City city) {

        List<City> list = cityService.selectByCityName(city.getCityName());
        if (list==null||list.size()==0){
            city.setCityType("1");
            city.setCreateTime(new Date());
            if (UserTokenManager.getToken()!=null){
                city.setCreateUser(UserTokenManager.getToken().getId());
                city.setUpdateUser(UserTokenManager.getToken().getId());
            }
            city.setCreateTime(new Date());
            city.setUpdateTime(new Date());
            city.setDelFlag("0");
            int result=cityService.insertSelective(city);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","区/县级地区录入成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","区/县级地区添加失败");
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
     *    @Description:  1.3 区/县级地区修改
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/updcounties",method = RequestMethod.POST)
    public Map updProvince(City city) {
        City city01= cityService.selectById(city.getId());
        if (city01==null){

            resultMap.put("status",20005);
            resultMap.put("msg","没有数据");
            resultMap.put("data",false);

        }else{

            city.setCreateTime(new Date());
            if (UserTokenManager.getToken()!=null){
                city.setUpdateUser(UserTokenManager.getToken().getId());
            }
            city.setUpdateTime(new Date());
            int result=cityService.updateSelective(city);

            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","区/县级地区修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","区/县级地区修改失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


    /**
     *    @Description:      1.3 区/县级地区删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delcounties",method = RequestMethod.POST)
    public Map delProvince(@RequestParam String id) {

        City city= cityService.selectById(id);
        if (city==null){

            int result=cityService.insertSelective(city);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","区/县级地区删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","区/县级地区删除失败");
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
