package com.prostate.system.util;

import com.prostate.system.entity.User;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.MessageDigest;

/**
 * @Author: bianyakun
 * @Date: 2018/4/19 16:43
 * @Todo:密码加盐的工具类
 */

public class MD5Util {

        // MD5加密
    public static User md5Password(String username, String password) {

        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes().toHex();
        String password_cipherText = new Md5Hash(password, username + salt, 2).toHex();
        User user = new User();

        user .setPassword(password_cipherText);
        user.setSalt(salt);
        user.setUsername(username);
        return user;
    }
}
