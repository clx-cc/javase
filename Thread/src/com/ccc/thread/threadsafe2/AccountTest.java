package com.ccc.thread.threadsafe2;

public class AccountTest {
    public static void main(String[] args) {
        Account act = new Account();
        //线程对象
        Thread c1 = new Customer(act);
        c1.setName("c1");
        Thread c2 = new Customer(act);
        c2.setName("c2");
        c1.start();
        c2.start();

    }
}
class Account{
    private Double balance = 0.0;
    //这里的同步监视器为this：是Account对象，是唯一的
    public synchronized void deposit(double amt){
        if (amt > 0){
            this.balance+=amt;
        }
        System.out.println(Thread.currentThread().getName()+"存钱："+amt+",余额为："+balance);
    }
}
class Customer extends Thread{
    Account account;
    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
//            synchronized (Customer.class){
                account.deposit(1000);
//            }

        }
    }
}
