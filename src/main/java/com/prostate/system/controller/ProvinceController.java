package com.prostate.system.controller;

import com.prostate.system.entity.City;
import com.prostate.system.entity.Node;
import com.prostate.system.service.CityService;
import com.prostate.system.shiro.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: developerfengrui
 * @Description:  省级地区管理
 * @Date: Created in 14:20 2018/4/23
 */
@RestController
@RequestMapping(value = "/province")
public class ProvinceController extends BaseController{

        @Autowired
          private CityService cityService;


    /**
     *    @Description:  检查数据接口
     *    @Date:  9:40  2018/4/20
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map checkProvinceName(@RequestParam("param") String param,@RequestParam("type") Integer type){
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
             *    @Description:  展示省级地区列表
          *    @Date:  14:43  2018/4/23
             *    @Params:   * @param null
             */

        @RequestMapping(value = "/findbypage")
        public List findByPage(@RequestParam(defaultValue = "cc9e0348b3c311e7b77800163e08d49b")String id,
                               @RequestParam(defaultValue = "1")Integer flag) {

            List<City> list=cityService.findByPage(id);
            if(list==null|list.size()==0){

                    resultMap.put("status",20007);
                    resultMap.put("msg","没有找到相关数据数据");
                    resultMap.put("rows",false);

            }else{
                resultMap.put("status",20000);
                resultMap.put("msg","数据查询成功");
                resultMap.put("rows",list);
            }

            List list1 =null;
            if (list!=null){
                list1=new ArrayList<>();
                for (City city:list){

                    Node node =new Node();
                    node.setId(city.getId());
                    node.setText(city.getCityName());
                    List list2 =cityService.findByPage(city.getId());
                    if (list2==null||list2.size()==0){

                    }else {
                        node.setState("closed");
                    }
                    list1.add(node);

                }
            }

            resultMap.put("list",list1);

            return list1;
        }

             /**
                 *    @Description: 级联菜单查询
                 *    @Date:  16:54  2018/5/2
                 *    @Params:   * @param null
                 */

         /*   public   List<Node> change(List<City> list){
                List <Node> list1 =new ArrayList<>();
                for (City city:list){

                    Node node =new Node();
                    node.setId(city.getId());
                    node.setText(city.getCityName());
                    if (cityService.findByPage(city.getId())!=null){

                        node.setChildren(change(cityService.findByPage(city.getId())));
                    }
                    node.setState("closed");
                    list1.add(node);

                }
                //System.out.println(list1);
                return list1;
            }*/




     /**
         *    @Description:  省级地区添加
         *    @Date:  16:11  2018/4/23
         *    @Params:   * @param null
         */

    @RequestMapping(value = "/addprovince",method = RequestMethod.POST)
    public Map addprovince(Node node) {
        City city =null;
        List<City> list = cityService.selectByCityName(node.getText());
        if (list==null||list.size()==0){
            city=new City();
            city.setParentCityId(node.getId());
            city.setCityName(node.getText());
            city.setCityType("1");
            //这里通过查询此图citytype等于0的id作为省区的pid,前台不用传

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
                resultMap.put("msg","省名插入成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","省名插入失败");
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
         *    @Description:  省级地区修改
         *    @Date:  16:30  2018/4/23
         *    @Params:   * @param null
         */

    @RequestMapping(value = "/updprovince",method = RequestMethod.POST)
    public Map updProvince(Node node) {
        System.out.println(node);
        City city =null;
        City city01= cityService.selectById(node.getId());
        if (city01==null){

                resultMap.put("status",20005);
                resultMap.put("msg","没有数据");
                resultMap.put("data",false);

        }else{
            city=new City();
            city.setId(node.getId());
            city.setCityName(node.getText());
            city.setCreateTime(new Date());
            if (UserTokenManager.getToken()!=null){
                city.setUpdateUser(UserTokenManager.getToken().getId());
            }
            city.setUpdateTime(new Date());
            int result=cityService.updateSelective(city);

            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","省名修改成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","省名修改失败");
                resultMap.put("data",false);
            }

        }
        return resultMap;
    }


    /**
     *    @Description:  省级地区删除
     *    @Date:  16:30  2018/4/23
     *    @Params:   * @param null
     */

    @RequestMapping(value = "/delprovince",method = RequestMethod.POST)
    public Map delProvince(@RequestParam String id) {

        City city= cityService.selectById(id);
        if (city!=null){
            if (UserTokenManager.getToken()!=null){
                city.setDeleteUser(UserTokenManager.getToken().getId());
            }
            city.setDeleteTime(new Date());
            city.setDelFlag("1");
            int result=cityService.updateSelective(city);
            if(result>0){
                resultMap.put("status",20000);
                resultMap.put("msg","省名删除成功");
                resultMap.put("data",false);
            }else{
                resultMap.put("status",20005);
                resultMap.put("msg","省名删除失败");
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
