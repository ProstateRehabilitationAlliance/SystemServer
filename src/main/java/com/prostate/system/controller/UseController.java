package com.prostate.system.controller;

import com.prostate.system.entity.User;
import com.prostate.system.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 10:12
 * @Todo:  系统管理员的控制类
 */

@RestController
@RequestMapping("/user")
public class UseController {


    @Autowired
    private UserService userService;//注入UserService的服务


    /***
     * @TODO: 用户注册服务
     *
     */
    @RequestMapping(value="/regist",method= RequestMethod.POST)
    //@RequiresPermissions("userInfo:add")//权限管理;
    public Map<String,Object> insertUser(User user){
        System.out.println("contrller"+user.getPassword());
        user.getPassword();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int r = userService.insertSelective(user);  //调用注册服务,如果注册成功返回1,如果注册时报返回0.
        //根据返回的数值判断是否注册成功,并返回不同的map.
        System.out.println("返回的值是"+r);
        if (r == 1){
            resultMap.put("data","1");
            resultMap.put("msg","注册成功");
        }else {
            resultMap.put("data", "0");
            resultMap.put("msg", "注册失败");
        }
        return resultMap;
    }

    /**
     * @Author: bianyakun
     * @Date: 2018/4/19 12:58
     * @todo:   管理员登录
     * @param:   * @param null
     */
//    @RequestMapping(value="/login",method= RequestMethod.GET)
//    @RequiresPermissions("userInfo:view")//权限管理;
//    public Map<String,Object> loginUser(HttpServletRequest request, Map<String, Object> map){
//
//        // 登录失败从request中获取shiro处理的异常信息。
//        // shiroLoginFailure:就是shiro异常类的全类名.
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "UnknownAccountException -- > 账号不存在：";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "IncorrectCredentialsException -- > 密码不正确：";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        map.put("msg", msg);
//        return map;
//    }

    /*不涉及权限管理的用户登录*/
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public Map<String,Object> userLogin(String username,String password){

        Map<String,Object> resultMap = new LinkedHashMap<>();
        int r = userService.userLogin(username,password);  //调用注册服务,如果注册成功返回1,如果注册时报返回0.
        //根据返回的数值判断是否注册成功,并返回不同的map.
        if (r == 1){
            resultMap.put("data","1");
            resultMap.put("msg","登录成功");
        }else {
            resultMap.put("data", "0");
            resultMap.put("msg", "登录失败");
        }
        return resultMap;

    }

}
