package com.ccc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadTest03 {
    public static void main(String[] args) {
        //创建线程任务对象
        MyThread03 target = new MyThread03();
        //把Callable对象交给FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(target);//FutureTask实现了Runnable接口
        //创建线程对象
        Thread t1 = new Thread(futureTask);
        //启动线程
        t1.start();

        System.out.println("main线程");
        //获得t1线程的call()方法的返回值
        try {
            //futureTask.get()：这是一个阻塞方法，如果想要获取分线程的返回值，而分线程却没有执行结束，此方法会导致主线程阻塞
            Integer sum = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
//定义一个线程任务类
class MyThread03 implements Callable<Integer>{
    //重写call()方法
    @Override
    public Integer call() throws Exception {
        //求1-100的和
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            sum += i;
        }
        //返回
        return sum;
    }
}
