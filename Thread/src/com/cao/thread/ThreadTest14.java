package com.cao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过Callable方法实现多线程
 */
public class ThreadTest14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程任务对象，将线程任务对象交给FutureTask对象
        FutureTask futureTask = new FutureTask(new MyThread14());
        //把FutureTask对象给Thread对象
        Thread t = new Thread(futureTask);
//        启动线程
        t.start();
        //获取线程的返回值：这个方法会对主线程main进行阻塞，因为主线程必须等待分支线程执行结束才能获取到这个返回结果
        //分支线程执行没有结束，程序不会继续向下执行，极大降低了效率
        System.out.println(futureTask.get());

    }
}

//定义一个任务类，实现Calable接口
//这是一个泛型接口，应该声明其返回结果数据类型
class MyThread14 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "=>" + i);
        }
        //会自动装箱
        return 100 + 200;
    }
}
