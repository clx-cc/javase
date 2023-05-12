package com.ccc.thread.singleton;

public class BankTest {
    static Bank b1 = null;
    static Bank b2 = null;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                b1 = Bank.getInstance();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}
class Bank{
    private Bank(){}
    private static Bank instance = null;

    public static Bank getInstance(){
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Bank();
        }
        return instance;
    }
}
