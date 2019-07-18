package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/15 15:40
 */
public class ExtendsInstanceTest {

    private String baseName="base";

    public ExtendsInstanceTest() {
        callName();
    }

    public void callName(){
        System.out.println(baseName);
    }
    static class Sub extends ExtendsInstanceTest{

       private String baseName="sub";

        public void callName(){
           System.out.println(baseName);
       }
    }

    public static void main(String[] args){
        ExtendsInstanceTest b=new Sub();
    }
}
