package com.ccc.thread.threadsafe1;

/**
 * 卖票测试多线程安全问题：实现Runnable接口测试
 * 使用同步代码块解决线程安全问题：
 */
public class WindowTest01 {
    public static void main(String[] args) {
        //创建线程任务对象
        SaleTicket1 s = new SaleTicket1();
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
class SaleTicket1 implements Runnable{
    //票数
     int ticket = 100;
    @Override
    public  void run() {
        while (true){
            //this是唯一的：在这里this表示当前对象，当前对象就是SaleTicket对象，这个线程任务对象我们只造了一个
                //所以对于线程t1,t2,t3来说，this对象是唯一的。
            synchronized(this){
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
