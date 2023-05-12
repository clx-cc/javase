package com.ccc.thread;

/**
 * 创建多线程的方式之二：实现Runnable接口
 */
public class CreateThreadTest02 {
    public static void main(String[] args) {
        //创建线程任务类对象：线程辅助类
        MyThread2 target = new MyThread2();
        //将线程任务类对象作为Thread类的构造器参数：真正的线程对象
        Thread thread = new Thread(target);
        //执行start()方法
        thread.start();

    }
}
//声明一个类，实现Runnable接口
class MyThread2 implements Runnable{
    //重写run()方法：方法体就是执行的操作
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}
