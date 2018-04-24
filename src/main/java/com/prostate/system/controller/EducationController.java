package com.prostate.system.controller;


import com.github.pagehelper.PageHelper;
import com.prostate.system.entity.Education;
import com.prostate.system.service.Educationservice;
import com.prostate.system.shiro.UserTokenManager;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/23 14:34
 * @Todo:学历信息控制类
 */
@RestController
@RequestMapping(value = "/edu")
public class EducationController extends BaseController{

    @Autowired
    private Educationservice educationservice;

    public static Map<String,Object> resultMap = new LinkedHashMap<>();


    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:53
     * @todo: 学历列表展示
     * @param:null
     */
    @GetMapping(value = "/select")
    public Map<String, Object> queryAllEducation(@RequestParam(defaultValue = "0") int pageNum,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Education> educations = educationservice.selectByParams();
        if (educations.isEmpty()){
            resultMap.put("msg","没有学历信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到学历信息");
            resultMap.put("data",educations);
        }
        return resultMap;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:53
     * @todo: 根据id查询学历信息
     * @param:null
     */
    @GetMapping(value = "/selectone")
    public Map<String, Object> queryEducationById( String educationID) {
        Education educations = educationservice.selectById(educationID);
        if (educations == null){
            resultMap.put("msg","没有学历信息");
            resultMap.put("status","20007");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功查询到学历信息");
            resultMap.put("data",educations);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:54
     * @todo: 新增学历记录
     * @param:   Education对象,主要是学历名称,学历编号和创建人的id
     */
    @PostMapping(value = "/insert")
    public Map<String, Object> insertEducation(Education education) {
        //首先判断所插入的大学是否已经存在
        List<Education> educations = educationservice.selectByName(education.getEducationName());
            if (educations.isEmpty()){
                //获取当前登录用户信息并设置为education的createID
                education.setCreateUser(UserTokenManager.getToken().getId());
                int r  = educationservice.insertSelective(education);
                if (r == 0){
                    resultMap.put("msg","插入学历信息失败");
                    resultMap.put("status","20005");
                    resultMap.put("data",null);
                 }else {
                    resultMap.put("msg","20000");
                    resultMap.put("status","成功插入学历信息");
                    resultMap.put("data",null);
                }
            }
            else {
                    resultMap.put("msg","20001");
                    resultMap.put("status","此信息已经存在");
                    resultMap.put("data",null);
                }

        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:55
     * @todo: 修改学历信息
     * @param: 新的学历对象
     */
    @PostMapping(value = "/update")
    public Map<String, Object> updateEducation(Education education) {
        String userID = UserTokenManager.getToken().getId();
        education.setUpdateUser(userID);
        int r  = educationservice.updateSelective(education);
        if (r == 0){
            resultMap.put("msg","修改学历信息失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","成功修改学历信息");
            resultMap.put("data",null);
        }
        return resultMap;
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:57
     * @todo: 根据id删除学历信息  此处的删除是假删除,只是把del_flag改变,因此是update操作
   * @param:  学历id
     */
    @PostMapping(value = "/delete")
    public Map<String, Object> deleteEducation(String educationID) {
        String userID = UserTokenManager.getToken().getId();
        //先根据id查询学历信息,
        Education education = educationservice.selectById(educationID);
        //将education相关的信息重新设置
        education.setDeleteUser(userID);
        education.setDelFlag("1");
        //将education重新写入
        int r  = educationservice.updateSelective(education);
        //int r  = educationservice.deleteById(educationID);
        if (r == 0){
            resultMap.put("msg","删除学历信息失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","删除学历成功");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/23 15:57
     * @todo: 根据名称查询学历信息
     * @param:  学历id
     */
    @GetMapping(value = "/selectbyname")
    public Map<String, Object> selectEducationByName(String educationName) {
       List<Education>  educations = educationservice.selectByName(educationName);
        if (educations.isEmpty()){
            resultMap.put("msg","查询失败");
            resultMap.put("status","20005");
            resultMap.put("data",null);
        }else {
            resultMap.put("msg","20000");
            resultMap.put("status","查询成功");
            resultMap.put("data",educations);
        }
        return resultMap;
    }

}
