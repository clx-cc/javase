package com.ccc.thread.communication;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 案例1：两个线程交替打印1-100
 */
public class PrintNumberTest {
    public static void main(String[] args) {
        //创建线程任务对象
        PrintNumber target = new PrintNumber();
        //创建线程对象
        Thread t1 = new Thread(target,"t1");
        Thread t2 = new Thread(target,"t2");
        //启动
        t1.start();
        t2.start();
    }
}
class PrintNumber implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        while (true){

            synchronized (this) {
                this.notify();
                if (num <= 100){
                    System.out.println(Thread.currentThread().getName()+"打印："+num);
                    num++;
                    //线程一旦执行此方法，就进入等待状态。同时会释放锁
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }

        }
    }
}
