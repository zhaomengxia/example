package com.linln.common.multithread;

/**
 *
 * java提供了三种创建线程的方法
 * 1.通过实现Runnable接口
 * 2.通过继承Thread类本身
 * 3.通过Callable和Future创建线程
 * @Author zhaomengxia
 * @create 2019/6/13 13:58
 */
public class CreateThread implements Runnable{

    private Thread t;

    private String threadName;


    public CreateThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Createing: "+threadName);
    }

    @Override
    public void run() {
        System.out.println("Running: "+threadName+"---");
        for (int j=4;j>0;j--){
            try {
                System.out.println("Thread: "+threadName+","+j);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread: "+threadName+"interrupted");
                e.printStackTrace();
            }
            System.out.println("Thread: "+threadName+" exiting");
        }
    }

    public void start(){
        System.out.println(threadName+"-----------");
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }

    public static void main(String[] args){

        CreateThread createThread=new CreateThread("Thread-1");

        createThread.start();

        CreateThread createThread1=new CreateThread("Thread-2");

        createThread1.start();
    }

}
