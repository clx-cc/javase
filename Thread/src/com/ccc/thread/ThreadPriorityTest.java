package com.ccc.thread;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100000; i++) {
                    if (i%2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }).start();
        //主线程
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 1; i <= 100000; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + " *******");
            }
        }
    }
}
