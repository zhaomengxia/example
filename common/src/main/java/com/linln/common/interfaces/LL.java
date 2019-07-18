package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/15 14:13
 */
public class LL {


    public static void main(String[] args){

        AA aa=new AA();

        BB bb=new BB();

        CC cc=new CC();

        DD dd=new DD();

        System.out.println(aa.get(aa)+"--"+aa.get(dd)+"--"+bb.get(bb)+"--"+bb.get(aa));


    }


}
