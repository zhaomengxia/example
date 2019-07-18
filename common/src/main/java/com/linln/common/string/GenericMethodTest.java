package com.linln.common.string;

/**
 * @Author zhaomengxia
 * @create 2019/7/2 14:18
 */
public class GenericMethodTest {

    public static <E> void printArray(E[] inputArray){


        for (E e:inputArray){
            System.out.printf("%s ",e);
        }

        System.out.println();
    }


    public static void main(String[] args){
        Integer[] integers={1,2,3,4,5};
        Double[] doubles={1.1,2.2,3.3,4.4};
        Character[] characters={'H','E','L','O'};
        System.out.println("整型数组元素：");
        printArray(integers);
        System.out.println("双精度型数组元素:");
        printArray(doubles);

        System.out.println("字符型数组元素：");
        printArray(characters);

    }

}
