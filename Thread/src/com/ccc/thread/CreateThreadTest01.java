package com.ccc.thread;

/**
 * 创建多线程的方式之一：继承Thread类
 */
public class CreateThreadTest01 {
    public static void main(String[] args) {
        //创建当前Thread子类的对象
        MyThread myThread = new MyThread();
        //通过myThread调用start方法
        myThread.start();
        //匿名子类
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
    }
}
//创建一个继承于Thread类的子类
class MyThread extends Thread{
    //重写run方法，将此线程要执行的操作，声明在此方法体内
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
