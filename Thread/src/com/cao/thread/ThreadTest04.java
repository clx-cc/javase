package com.cao.thread;

/**
 * 怎么获取当前线程对象？
 * 怎么获取当前线程对象的名字？
 * 修改线程对象的名字
 */
public class ThreadTest04 {
    public static void main(String[] args) {
        //创建一个线程对象
        Thread thread = new Thread(new MyThread03());
        //启动线程
        thread.start();
        //获取线程对象的名字
        System.out.println(thread.getName());
        //设置线程的名字
//        thread.setName("tttttttttttt");
//        System.out.println(thread.getName());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10; i++) {
                    //其中Thread.currentThread()就是当前正在执行的线程对象。怎么判断是哪个线程呢？

                    System.out.println(Thread.currentThread().getName() + "->" + i);
                }

            }
        });
        t.start();

    }
}

class MyThread03 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "——》" + i);
        }

    }
}
