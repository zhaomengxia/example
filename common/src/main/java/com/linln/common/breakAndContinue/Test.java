package com.linln.common.breakAndContinue;
/**
 * @Author zhaomengxia
 * @create 2019/7/16 16:25
 */
public class Test {
    public static void main(String[] args){
        System.out.println("break:----------------");
        for (int i=0;i<=10;i++){
            if (i==5){
                System.out.println("i值为："+i+" 终止循环");
                break;
            }
            System.out.println(i);
        }
        System.out.println("continue:-------------");
        for (int i=0;i<=10;i++){
            if (i==5){
                System.out.println("i值为："+i+" 跳出本次循环");
                continue;
            }
            System.out.println(i);
        }
    }
}
