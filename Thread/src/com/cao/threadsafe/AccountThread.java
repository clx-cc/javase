package com.cao.threadsafe;

public class AccountThread implements Runnable{
    //两个线程必须共享一个实例对象
    Account account = null;
    //通过构造方法传递过来一个实例
    public AccountThread(Account account){
        this.account = account;
    }
    @Override
    public void run() {
        //取款
        double money = 10000;
        account.withdraw(5000);
        System.out.println(account.getActno() + "账户的余额是：" + account.getBalance());
    }
}
