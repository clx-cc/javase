package com.cao.thread;

/**
 * 实现线程的第二种方式：
 *         编写一个类，实现java.lang.Runnable接口，重写run方法
 *
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        //创建一个线程对象
        Thread thread = new Thread(new MyThread02());
        //启动线程
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程——》" + i);
        }

    }
}

class MyThread02 implements Runnable{

    @Override
    public void run() {
        //重写run方法，编写程序，这段程序运行在分支线程中（分支栈）
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支栈——》" + i);
        }
    }

}
