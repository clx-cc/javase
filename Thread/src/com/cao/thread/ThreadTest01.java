package com.cao.thread;

/**
 * 实现线程的第一种方式：
 *          编写一个类继承java.lang.Thread,重写run方法
 *          怎么创建一个线程
 *              new就行
 *          怎么启动一个线程？
 *              调用线程对象的start方法
 *
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        //这是一个main方法，属于主线程，在主栈中运行

        //新建一个分支线程对象
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();
        //以下的代码运行在主线程中
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程——》" + i);
        }

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        //重写run方法，编写程序，这段程序运行在分支线程中（分支栈）
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支栈——》" + i);
        }
    }
}
