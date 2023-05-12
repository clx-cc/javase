package com.ccc.thread;

public class InterruptTest {
    public static void main(String[] args) {
        Thread t = new MyThread4();
        t.start();

        //设置主线程睡眠5秒之后，t线程终止睡眠（即主线程做完了自己的事情）
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终断t线程的睡眠（采用异常处理机制：让t线程的sleep方法抛出InterruptedException异常）
        t.interrupt();

    }
}
class MyThread4 extends Thread{
    @Override
    public void run() {
        System.out.println("begin");
        try {
            //睡眠一年
            Thread.sleep(365 * 24 * 60 * 60 *1000);//让这边抛出异常
        } catch (InterruptedException e) {//这边捕捉异常
            //打印异常信息
            e.printStackTrace();//不打印异常信息就看不到报错
        }
        System.out.println("end");
    }
}
