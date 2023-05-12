package com.cao.thread;

/**
 * 怎么终止一个线程的执行？
 *
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        //创建线程对象
        MyThread05 myThread05 = new MyThread05();
        Thread thread = new Thread(myThread05);
        //改名字
        thread.setName("t");
        //启动线程
        thread.start();

        //模拟5秒后终止线程
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程，直接调用run属性，改为false
        myThread05.run = false;
    }
}
class MyThread05 implements Runnable{
    //打一个boolean标记
    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(run){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //终止当前线程执行
                return;
            }

        }
    }
}
