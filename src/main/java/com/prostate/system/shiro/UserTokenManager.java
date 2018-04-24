package com.prostate.system.shiro;

import com.prostate.system.entity.User;
import org.apache.shiro.SecurityUtils;

public class UserTokenManager extends TokenManager{
   /**
    * 获取当前登录的用户对象
    * 
    * @return
    * @return
    */
   public static User getToken() {
      return (User) SecurityUtils.getSubject().getPrincipal();
   }

   /**
    * 登录
    * @return
    */
   public static User login(User user, Boolean rememberMe) {
      ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
      token.setRememberMe(false);
      SecurityUtils.getSubject().login(token);
      return getToken();

   }


}