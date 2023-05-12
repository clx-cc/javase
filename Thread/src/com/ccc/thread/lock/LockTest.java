package com.ccc.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Thread t1 = new SaleTicket();
        t1.setName("t1");
        Thread t2 = new SaleTicket();
        t2.setName("t2");
        Thread t3 = new SaleTicket();
        t3.setName("t3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket extends Thread{
    static int ticket = 100;

    //创建Lock的实例，需要确保多个线程共用同一个Lock实例：需要考虑将此对象声明为static final
    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //执行lock方法，锁定对共享资源的调用
                lock.lock();
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            } finally {
                //释放对共享资源的调用
                lock.unlock();
            }

        }
    }
}
