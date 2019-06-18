package com.linln.common.multithread;

/**
 * 通过继承Thread来创建线程
 * @Author zhaomengxia
 * @create 2019/6/13 14:21
 * 创建一个线程的第二种方法是创建一个新的类，该类继承Thread类，然后创建该类的实例
 * 继承类必须重写run（）方法，该方法是新线程的入口点。也必须调用start（）方法测i能执行
 *
 *该方法虽被列为一种多线程实现方式，但是本质上也是实现了Runnable接口的一个实例
 */
public class CreateThreadTwo extends Thread {

    private Thread t;

    private String threadName;

    public CreateThreadTwo(String name, String threadName) {
        super(name);
        this.threadName = threadName;
        System.out.println("Creating: "+threadName);
    }


    public void run(){
        System.out.println("Running: "+threadName);

        for (int j=4;j>0;j--){
            System.out.println("Thread: "+threadName +","+j +" do something");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

                System.out.println("Thread: "+threadName+" interrupted");

                e.printStackTrace();
            }

            System.out.println("Thread: "+threadName+" exiting");

        }

    }


    public void start(){
        System.out.println("Thread: "+threadName+" starting");
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }



    public static void main(String[] args){

        CreateThreadTwo createThreadTwo=new CreateThreadTwo("Thread","Thread-1");

        createThreadTwo.start();

        CreateThreadTwo createThreadTwo1=new CreateThreadTwo("Thread","Thread-2");

        createThreadTwo1.start();

    }


}
