package com.ccc.thread.threadsafe2;

/**
 * 卖票测试多线程安全问题：采用继承方式实现
 *  同步方法解决线程安全问题
 */
public class WindowTest02 {
    public static void main(String[] args) {
        Thread t1 = new SaleTicket2();
        t1.setName("t1");
        Thread t2 = new SaleTicket2();
        t2.setName("t2");
        Thread t3 = new SaleTicket2();
        t3.setName("t3");
        //启动
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket2 extends Thread{
    static int ticket = 100;
    static boolean isFalse = true;
    @Override
    public void run() {
        while (isFalse){
                show();
        }
    }
    //出现线程安全的实例方法
    //或者将show方法改变为静态方法，因为静态方法的同步监视器是类本身，只有一个，是唯一的。
//    public synchronized static void show(){
    public synchronized  void show(){
        //这里的同步监视器只能是this：这里的this代表不同的对象（t1,t2,t3)，不唯一，解决不了线程安全
//    public synchronized void show(){
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
