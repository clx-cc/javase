package com.cao.threadsafe;

public class Test {
    public static void main(String[] args) {
        //创建一个账户对象
        Account account = new Account("act-001",10000);
        //创建两个线程对象：将账户对象传递过去，两个账户就共享一个实例对象
        Thread t1 = new Thread(new AccountThread(account));
        Thread t2 = new Thread(new AccountThread(account));
        t1.setName("t1");
        t2.setName("t2");
        //启动
        t1.start();
        t2.start();

    }
}
