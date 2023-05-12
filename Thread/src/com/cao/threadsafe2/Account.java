package com.cao.threadsafe2;

/**
 * 账户类
 * 使用线程排队机制，多个线程对账户进行取款，不会出现线程安全问题
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
        //以下这几行代码必须是线程同步的，不能并发
        //一个线程执行结束之后，另一个线程才能进来执行
        /*
            线程同步机制的语法是:
            synchronized(){
                线程同步代码块
            }
            synchronized后面小括号中传的这个数据是相当关键的
            这个数据必须是多线程共享的数据。才能达到线程同步
            （）中写什么？那要看想要哪些线程同步
            括号中写的是需要线程排队的线程对象共享的对象？
            这里共享的对象就是Account
         */
        synchronized(this){
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }

    }
}
