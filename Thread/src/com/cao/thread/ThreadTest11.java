package com.cao.thread;

/**
 * 线程的让位方法：static void yield    ()
 *      当前运行的线程暂停执行，由运行状态转化为就绪状态
 *      yield方法不是阻塞方法
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable02());
        t.setName("t");
        //设置线程的优先级
        t.setPriority(10);
        //启动线程
        t.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }

    }
}
class MyRunnable02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }

    }
}
