package com.ccc.thread.deadlock;

public class DeadLockTest01 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        //第一个线程
        new Thread(){
            @Override
            public void run() {
                synchronized (sb1){
                    sb1.append("a");
                    sb2.append("1");
                    //增加死锁的概率：当前线程拿到sb1的同步监视器时，先等一下，不要着急获得sb2的同步监视器
                        //让另一个线程先获取sb2的同步监视器，这样就需要等待sb2释放才会继续执行
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2){
                        sb1.append("b");
                        sb2.append("2");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
        //第二个线程
        new Thread(){
            @Override
            public void run() {
                synchronized (sb2){
                    sb1.append("c");
                    sb2.append("3");
                    //这里又需要等sb1释放锁
                    synchronized (sb1){
                        sb1.append("d");
                        sb2.append("4");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
    }
}
