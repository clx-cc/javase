package com.cao.thread;

/**
 * 守护线程
 *      在用户线程执行结束后自动停止
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        //创建一个非守护线程
        Runnable target = new MyThread12();
        Thread t = new Thread(target);
        //因为不是守护线程，所以主线程执行结束程序不会停止，会陷入死循环
        //设置t线程为守护线程,此线程在用户线程全都执行结束后，会自动停止
        t.setDaemon(true);
        t.start();

        //主线程是用户线程
        //程序循环10次主线程执行结束
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class MyThread12 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        //死循环
        while (true){
            System.out.println(Thread.currentThread().getName() + "-->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
