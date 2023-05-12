package com.cao.thread;

/**
 * 怎么终止一个正在休眠的线程？
 *
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        //创建线程对象
        Thread t = new Thread(new MyThread04());
        t.setName("t");
        //启动线程
        t.start();
        //t线程休眠时间太久了，如果中途想要t线程停止休眠，怎么办？
            //注意：中断线程的休眠，不是中断一个线程的执行，只是让一个线程从”阻塞状态“到”运行状态“
        //我们让t线程5秒后，停止休眠
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断休眠（这种中断休眠的方式靠的是java的异常处理方式）
        t.interrupt();


    }
}
class MyThread04 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + "begin");
        try {
            //这个线程会休眠一年
            //只要调用interrupt方法，就会出现异常sleep interrupted
            Thread.sleep(1000 * 60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
            //打印异常信息
            e.printStackTrace();
        }
        //一年后会执行这行代码
        System.out.println(Thread.currentThread().getName() + "--->" + "end");
    }
}
