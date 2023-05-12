package com.cao.thread;

public class ThreadTest09 {
    public static void main(String[] args) {
        //创建一个线程对象
        Thread t = new Thread(new MyThread06());
        //启动线程
        t.start();
        System.out.println(Thread.currentThread().getName() + "线程");
        //合并线程
        try {
            //join方法使当前线程进入阻塞状态，t线程执行，直到t线程执行结束，当前线程才可以继续执行。
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class MyThread06 implements Runnable{
    @Override
    public void run() {
        System.out.println("另一个线程");
    }
}
