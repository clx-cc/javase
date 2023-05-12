package com.cao.thread;

/**
 * 关于线程的优先级
 */
public class ThreadTest10 {
    public static void main(String[] args) {
//        System.out.println("线程的最高优先级" + Thread.currentThread().MAX_PRIORITY);
//        System.out.println("线程的最低" + Thread.MIN_PRIORITY);
//
//        Thread currentThread = Thread.currentThread();
//        System.out.println(currentThread + "线程的默认优先级" + currentThread.getPriority());
        Thread t = new Thread(new MyRunnable01());
        t.setName("t");
        //设置线程的优先级
        t.setPriority(10);
        //启动线程
        t.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }

    }
}
class MyRunnable01 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }

    }
}
