package com.linln.common.string;

/**
 * @Author zhaomengxia
 * @create 2019/6/26 16:14
 */
public class VariableDemo {

    String name="成员变量";

    public void show(){
        String name="局部变量";
        System.out.println(this.name);
    }

    public static void main(String[] args){
        new VariableDemo().show();
    }
}
