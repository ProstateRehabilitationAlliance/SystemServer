package com.prostate.system.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ShiroToken extends UsernamePasswordToken implements java.io.Serializable {

   private static final long serialVersionUID = -6451794657814516274L;

   private String password;

   public ShiroToken(String username, String password) {
      super(username, password);
      this.password = password;
   }

   public String getPasswords() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}