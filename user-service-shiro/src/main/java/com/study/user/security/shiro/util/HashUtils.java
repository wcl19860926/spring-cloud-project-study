package com.study.user.security.shiro.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public  final class  HashUtils {

    private  HashUtils(){

    }


    public static String  md5Hash(String  plainPassword , String salt , int hashIterations){

      return  new Md5Hash(plainPassword, salt,  hashIterations).toString();

    }



}
