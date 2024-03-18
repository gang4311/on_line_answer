package com.tencent.wxcloudrun.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {

    public static String getEncryptionStr(String source,String salt,int hashIterations){
       return new Md5Hash(source, salt, hashIterations).toString();
    }
}
