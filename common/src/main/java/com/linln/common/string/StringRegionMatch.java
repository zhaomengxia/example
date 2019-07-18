package com.linln.common.string;

/**
 * @Author zhaomengxia
 * @create 2019/6/25 10:00
 */
public class StringRegionMatch {

    public static void main(String[] args){

        String first="Welcome to Microsoft";

        String second="I work with microsoft";
        //比较的是Microsoft和microsoft
        boolean match1=first.regionMatches(11,second,12,9);

        //第一个参数为true标识忽略大小写区别，比较的是Microsoft和microsoft
        boolean match2=first.regionMatches(true,11,second,12,9);

        System.out.println(match1+"----"+match2);

    }


}
