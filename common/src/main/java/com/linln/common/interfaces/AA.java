package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/15 14:13
 */
public class AA {
    private String name;
    String get(DD dd){return "AD";}
    String get(AA a){return "AA";}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AA(String name) {
        this.name = name;
    }

    public AA() {
        System.out.println("AA构造方法执行-----");
    }
}
