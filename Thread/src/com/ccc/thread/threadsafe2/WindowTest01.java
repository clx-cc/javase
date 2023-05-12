package com.ccc.thread.threadsafe2;

/**
 * 卖票测试多线程安全问题：采用继承方式实现
 *  同步代码块解决线程安全问题
 */
public class WindowTest01 {
    public static void main(String[] args) {
        Thread t1 = new SaleTicket1();
        t1.setName("t1");
        Thread t2 = new SaleTicket1();
        t2.setName("t2");
        Thread t3 = new SaleTicket1();
        t3.setName("t3");
        //启动
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket1 extends Thread{
    //ticket不是三个线程所共享的，所以用static修饰
    static int ticket = 100;
    @Override
    public void run() {
        while (true){
            //这边就不能使用this了，因为this代表的是线程对象
                //这边我们有三个线程对象，this指向是不同的线程对象
            synchronized (SaleTicket1.class) {
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket-=1;
                }else{
                    break;
                }
            }
        }
    }
}
