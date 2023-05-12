package com.cao.deadlock;

/**
 *      自己实现一个死锁
 *              这个程序会陷入死锁：表示程序运行正常，不会报错，永远不会执行结束。
 */
public class DeadLock {
    public static void main(String[] args) {
        //创建两个实例对象
        Object o1 = new Object();
        Object o2 = new Object();
        //创建两个线程
        Thread t1 = new Thread(new MyThread01(o1,o2));
        Thread t2 = new Thread(new MyThread02(o1,o2));
        t1.setName("t1");
        t2.setName("t2");
        //启动线程
        t1.start();
        t2.start();
    }
}
class MyThread01 implements Runnable{
    Object o1 = null;
    Object o2 = null;
    public MyThread01(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        //在这个run方法中执行o1，再执行o2
        synchronized (o1){
            //让o1休眠1秒：为了让t1线程在执行o1调用o1的时候，t2线程在调用o2
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }

    }
}
class MyThread02 implements Runnable{
    Object o1 = null;
    Object o2 = null;
    public MyThread02(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        //在这个run方法中执行o2，再执行o1
        synchronized (o2){
            //先让o2休眠1秒:为了在t2线程调用o2的时候，t1线程在调用o1
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }

    }
}