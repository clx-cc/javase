package com.ccc.thread;

public class ThreadAPITest {
    public static void main(String[] args) throws InterruptedException {
        //创建一个线程对象:匿名内部类的形式
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i <= 100000; i++) {
                    if (i%2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        });
        t1.start();
        //主线程
        for (int i = 1; i <= 100000; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + " *******");
            }
            if (i==5001)
                t1.join();
        }



    }
}

