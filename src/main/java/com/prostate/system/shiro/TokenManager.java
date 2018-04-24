package com.prostate.system.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * Shiro管理下的Token工具类
 */
public class TokenManager {
   
   /**
    * 获取当前用户的Session
    * 
    * @return
    */
   public static Session getSession() {
      return SecurityUtils.getSubject().getSession();
   }

   /**
    * 把值放入到当前登录用户的Session里
    * 
    * @param key
    * @param value
    */
   public static void setVal2Session(Object key, Object value) {
      getSession().setAttribute(key, value);
   }

   /**
    * 从当前登录用户的Session里取值
    * 
    * @param key
    * @return
    */
   public static Object getVal2Session(Object key) {
      return getSession().getAttribute(key);
   }


   /**
    * 判断是否登录
    * 
    * @return
    */
   public static boolean isLogin() {
      return null != SecurityUtils.getSubject().getPrincipal();
   }

   /**
    * 退出登录
    */
   public static void logout() {
      SecurityUtils.getSubject().logout();
   }

}