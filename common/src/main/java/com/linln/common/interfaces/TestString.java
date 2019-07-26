package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/24 17:33
 */
public class TestString {

   public static void main(String[] args){
       String str1="abc";
       String str2="ab"+"c";
       System.out.println(str1==str2);
       String str3="ab";
       String str4=str3+"c";
       System.out.println(str1==str4);

   }
}
