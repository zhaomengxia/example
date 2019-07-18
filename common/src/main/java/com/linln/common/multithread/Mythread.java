package com.linln.common.multithread;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;

/**
 * @Author zhaomengxia
 * @create 2019/6/28 13:09
 */
public class Mythread implements Callable {
//    static String s="yes";


    public static void main(String[] args){

        new Thread().start();

    }

    @Override
    public Object call() throws Exception {
        String s="qqq";
        return s;
    }
}
