package com.linln.common.string;


/**
 * @Author zhao
 * @create 2019/6/25 10:32
 */
public class Test {

    public static final int end=101;
    public static final int start=end-1;


    public static void main(String[] args) {
//        int j=0;
//        for (int i=start;i<=end;i++){
//            j++;
//            System.out.println("-------------");
//        }
////
//        System.out.println(j);
//        System.out.println("kkkkkkkkkkkkkkkkk");
//        check();
        System.out.println(findResult());
    }
    public static void check() {

        Integer one = 127;

        Integer two = 127;

        System.out.println("127  " + (one == two));
    }

    public static Integer findResult(){
        Integer a=5;
        try {
             return a=6;
        }catch (Exception e){
             return a=7;
        }finally {
            return a=8;
        }
    }

}
