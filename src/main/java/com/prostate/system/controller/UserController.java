package com.prostate.system.controller;

import com.prostate.system.entity.User;
import com.prostate.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 10:12
 * @Todo:  系统管理员的控制类
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    Map<String,Object> resultMap = new LinkedHashMap<>();

    @Resource
    private UserService userService;//注入UserService的服务



    /***
     * @TODO: 用户注册服务
     * @param :User对象
     * @return:
     */
    @RequestMapping(value="/regist",method= RequestMethod.POST)
   // @RequiresPermissions("userInfo:add")//权限管理;
    public Map<String,Object> insertUser(User user){
        //根据用户名判断用户是否已经存在
        List<User> list = userService.findUserWihtUserName(user.getUsername());
        if (list.isEmpty()){
            int r = userService.insertSelective(user);  //调用注册服务,如果注册成功返回1,如果注册时报返回0.
            //根据返回的数值判断是否注册成功,并返回不同的map结果.
            if (r == 1){
                resultMap.put("status","20000");
                resultMap.put("msg","注册成功");
                resultMap.put("data",null);
            }else {
                resultMap.put("status", "20005");
                resultMap.put("msg", "注册失败");
                resultMap.put("data",null);
            }
        }else {
            resultMap.put("status", "20001");
            resultMap.put("msg", "用户已经存在");
            resultMap.put("data",null);
        }
        return resultMap;
    }

    /**
     *  登陆认证，检查账号密码是否正确。成功则跳转到index.html，错误则跳转到对应的error.html
     * @param userName
     * @param password
     * @return
     */
    @PostMapping(value="/login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password") String password){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,password);
        Subject subject= SecurityUtils.getSubject();

        try {
            subject.login(usernamePasswordToken);
        }catch (IncorrectCredentialsException ice){
            resultMap.put("error","password error");
            return "error";
        }catch (UnknownAccountException uae) {
            resultMap.put("error","userName error");
            return "error";
        }catch (ExcessiveAttemptsException eae) {
            resultMap.put("error","time error");
            return "error";
        }
        return "index";
    }


    /**
     * @Author: bianyakun
     * @Date: 2018/4/20 8:44
     * @todo:   根据用户名查询用户信息
     * @param:   * @param null
     */
    @GetMapping(value = "/select")
    public Map<String,Object> userSelect(String username){
        List<User> users = userService.findUserWihtUserName(username);  //调用查询服务,如果注册成功返回1,如果注册时报返回0
        //根据返回的数值判断是否存在用户,并返回不同的map.
        if(users.isEmpty()){
           resultMap.put("data",null);
           resultMap.put("msg","用户不存在");
           resultMap.put("status","20007");
       }else{
           resultMap.put("status", "20000");
           resultMap.put("msg", "用户已经存在");
           resultMap.put("data",users.get(0));
        }
        return resultMap;
    }


}
