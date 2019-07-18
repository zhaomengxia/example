package com.linln.common.string;

/**
 * 下面演示通过两种方式创建字符串，并测试其性能
 * @Author zhaomengxia
 * @create 2019/6/25 10:13
 */
public class StringComparePerformance {

    public static void main(String[] args){
        long startTime=System.currentTimeMillis();

        for (int i=0;i<50000;i++){

            String s1="hello";

            String s2="world";

        }

        long endTime=System.currentTimeMillis();

        System.out.println("通过String 关键词创建字符串："+(endTime-startTime)+"毫秒");

        long startTime1=System.currentTimeMillis();

        for (int j=0;j<50000;j++){

            String s1=new String("hello");

            String s2=new String("world");

        }
        long endTime1=System.currentTimeMillis();

        System.out.println("通过String对象创建字符串："+(endTime1-startTime1)+"毫秒");


    }


}
