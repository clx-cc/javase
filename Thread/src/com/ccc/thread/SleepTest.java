package com.ccc.thread;

public class SleepTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread3();
        t1.setName("t1");
        t1.start();

        //调用sleep方法
        try {
            //问题：这行代码会让哪个线程陷入睡眠？t1还是main?
                //主线程陷入睡眠
            t1.sleep(5000);//这个方法是一个静态方法，就算用对象调用也和对象没有关系，最后还是会转换成Thread.sleep(5000)
                                //这行代码的作用是让当前线程进入休眠，即出现在哪个线程中就让哪个线程进入休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world!");

    }
}
class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
