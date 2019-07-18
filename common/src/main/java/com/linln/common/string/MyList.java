package com.linln.common.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/7/3 10:43
 */
public class MyList {

    public static List<String> list = new ArrayList<>();

    class Demo {
        public void main(String[] args) {
            MyList myList = new MyList();
            myList.list.add("123456");
            list = null;
        }
    }
}