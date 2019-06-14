package com.linln.modules.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhaomengxia
 * @create 2019/6/12 16:42
 */
public class CollectionTests {
    public static void main(String[] args) {
        StramMethod();
        iteratorMethod();
    }

    private static void StramMethod() {
        long t1 = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            List<String> a = new ArrayList<>();
            a.add("aaa");
            a.add("adc");
            a.add("qwe");
            a.add("gac");
            a.add("aew");
            List<String> b = a.stream().filter(String->!String.contains("c")).collect(Collectors.toList());
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Stream方法用时："+(t2-t1));
    }

    private static void iteratorMethod() {
        long t3 = System.currentTimeMillis();
        for(int i = 0;i<10000;i++) {
            List<String> a = new ArrayList<>();
            a.add("aaa");
            a.add("adc");
            a.add("qwe");
            a.add("gac");
            a.add("aew");
            List<String> b = new ArrayList<>();
            Iterator<String> it = a.iterator();
            while(it.hasNext()) {
                String x = it.next();
                if(x.contains("c")) {
                    it.remove();
                }
            }
            b.addAll(a);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("Iterator方法用时："+(t4-t3));
    }
}
