package com.cao.thread;

/**
 * 采用匿名内部类方式创建一个线程对象
 *
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        //创建一个线程对象
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //编写代码
                for (int i = 0; i < 1000; i++) {
                    System.out.println("分支栈——》" + i);
                }

            }
        });
        //启动一个线程
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程——》" + i);
        }

    }
}
