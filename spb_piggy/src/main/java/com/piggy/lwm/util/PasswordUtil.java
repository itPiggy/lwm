package com.piggy.lwm.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

public class PasswordUtil {
    // 生成MD5哈希密码
    public static String degistPwd(String pwd){
        return new Md5Hash(pwd, PrjConstant.PWD_SALT, PrjConstant.PWD_ITERATIONS).toBase64();
    }

    // SHA256哈希密码
    public static String digestPwdSHA256(String pwd) {
        return new Sha256Hash(pwd, PrjConstant.PWD_SALT, PrjConstant.PWD_ITERATIONS).toBase64();
    }
}
