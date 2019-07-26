package com.linln.common.interfaces;

/**
 * @Author zhaomengxia
 * @create 2019/7/15 14:13
 */
public class BB extends AA {
    String get(AA aa){
        return "BA";
    }

    String get(BB b){
        return "BB";
    }

    public BB(String name) {
        super(name);
    }

    public BB() {
        System.out.println("BB构造方法执行-------");
    }

   public void AA(){
       System.out.println("这里加入了void，所以不是构造方法，所以new AA()，不会执行到这里");
   }

   public static void main(String[] args){
       new BB();
       new AA();
   }
}
