package com.prostate.system.controller;

import com.prostate.system.entity.User;
import com.prostate.system.service.UserService;
import com.prostate.system.shiro.UserTokenManager;
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
            //将当前登录的用户信息作为create_user加入user中
            user.setCreateUser(UserTokenManager.getToken().getId());
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
    public Map<String, Object> login(@RequestParam("userName")String userName, @RequestParam("password") String password){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,password);
        User user =new User();
        user.setUsername(userName);
        user.setPassword(password);
        try {
            UserTokenManager.login(user,false);
            System.out.println( UserTokenManager.getToken());
            resultMap.put("data",null);
            resultMap.put("msg","登录成功");
            resultMap.put("status","20000");
        }catch (IncorrectCredentialsException ice){
            resultMap.put("data",null);
            resultMap.put("msg","密码错误");
            resultMap.put("status","20004");
        }catch (UnknownAccountException uae) {
            resultMap.put("data",null);
            resultMap.put("msg","用户名错误");
            resultMap.put("status","20004");
        }catch (ExcessiveAttemptsException eae) {
            resultMap.put("data",null);
            resultMap.put("msg","token失效");
            resultMap.put("status","20008");
        }

        return resultMap;
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
