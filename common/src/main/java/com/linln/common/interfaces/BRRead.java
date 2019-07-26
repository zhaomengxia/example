package com.linln.common.interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhaomengxia
 * @create 2019/7/19 14:22
 */
public class BRRead {
    public static void main(String[] args) throws IOException {
//        char a;
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符，按下‘q’键退出");
//
//        String str;
//        System.out.println("Enter lines of text");
//        System.out.println("Enter 'end' to quit");
//
//        do {
//            a=(char)br.read();
//            System.out.println(a);
//
//            str=br.readLine();
//            System.out.println(str);
//
//        }while (a!='q');


        String s[] [] =new String[2][];
        s[0]=new String[2];
        s[1]=new String[3];
        s[0][0]=new String("Good");
        s[0][1]=new String("Luck");
        s[1][0]=new String("to");
        s[1][1]=new String("you");
        s[1][2]=new String("!");

        for (String[] s1:
             s) {
            for (String s2:
                 s1) {
                System.out.println(s2);
            }
        }
    }
}
