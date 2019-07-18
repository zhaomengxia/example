package com.linln.common.interfaces;

/**
 * 接口A可以多继承接口B和接口H
 * @Author zhaomengxia
 * @create 2019/7/15 13:38
 */
public interface A extends B,H{
    public String eat();
    public String drink();
    public String s = null;
}
