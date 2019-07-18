package com.linln.common.string;

/**
 * @Author zhaomengxia
 * @create 2019/6/25 10:07
 */
public class RemoveChatAt {

    public static void main(String[] args){
        String str="this is Java";
        System.out.print(removeChatAt(str,3));
    }
    //用字符串函数substring()函数来删除字符串中的一个字符，将功能封装在下面的方法中
    public static String removeChatAt(String s, int pos){
       return s.substring(0,pos)+s.substring(pos+1);
    }

}
