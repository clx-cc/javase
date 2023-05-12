package com.cao.threadsafe;

/**
 * 账户类
 * 不使用线程排队机制，多个线程对账户进行取款，会出现线程安全问题
 */
public class Account {
    private String actno;
    private double balance;

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
    public void withdraw(double money){
        //取款之前的余额
        double before = this.getBalance();
        //取款之后的余额
        double after = before - money;
        //更新余额
        this.setBalance(after);
    }
}
