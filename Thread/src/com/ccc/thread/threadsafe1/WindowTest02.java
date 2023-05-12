package com.ccc.thread.threadsafe1;

/**
 * 卖票测试多线程安全问题：实现Runnable接口测试
 * 同步方法解决线程安全问题
 */
public class WindowTest02 {
    public static void main(String[] args) {
        //创建线程任务对象
        SaleTicket2 s = new SaleTicket2();
        //创建三个线程对象模拟卖票窗口
        Thread t1 = new Thread(s);
        t1.setName("t1");
        Thread t2 = new Thread(s);
        t2.setName("t2");
        Thread t3 = new Thread(s);
        t3.setName("t3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket2 implements Runnable{
    //票数
     int ticket = 100;
     boolean isFalse = true;
    @Override
    public  void run() {
        while (isFalse){
                show();
        }
    }
    //此时同步监视器只能是this：这道题目中this就只是线程任务对象，只有一个，符合要求。
    public synchronized void show(){//出现线程安全的实例方法
        if (ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket-=1;
        }else{
            isFalse = false;
        }
    }
}
