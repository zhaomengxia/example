package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/15 13:39
 *
 * 接口中所有的属性都是static final修饰的，即常量。由于JVM的底层机制，所有static final修饰的变量在编译时期就确定了值，
 * 在使用的时候，在接口的子类改变常量值，编译的时候就不能通过。
 */
public interface B {
    public String eat();
    public String drink();
    public String action();
    public String s = "";
}
