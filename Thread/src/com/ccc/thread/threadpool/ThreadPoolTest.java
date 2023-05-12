package com.ccc.thread.threadpool;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(0, 2, 1, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i%2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        });
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    if (i%2 != 0){
                        sum += i;
                    }
                }
                return sum;
            }
        });
        Integer res = 0;
        try {
             res = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("执行结果为："+res);
    }
}
