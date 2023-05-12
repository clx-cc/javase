package com.cao.exam01;

/**
 * 思考1：t1和t2线程共享同一个MyClass实例，在这个以实例中有两个实例方法：doSome和doOther
 *  问：
 *      给doSome方法添加关键字synchronized，doOther不添加，当t1线程执行run方法，调用doSome方法时
 *      t2线程进入执行run方法，调用实例方法doOther,请问t2线程需要等待t1线程执行结束吗？
 *  答：
 *      不需要，虽然t1和t2共享同一个对象，但是synchronized只作用于这个实例的doSome方法，表示这个实例方法在
 *      同一时刻只能被一个线程调用，而没有synchronize关键字的其他实例方法还是可以被多个线程随时调用。
 */
public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个共享对象
        MyClass myClass = new MyClass();
        //创建两个线程对象
        Thread t1 = new Thread(new MyThread01(myClass));
        Thread t2 = new Thread(new MyThread01(myClass));
        //设置线程的名字
        t1.setName("t1");
        t2.setName("t2");
        //启动线程：让t1先启动
        t1.start();
        //sleep方法是为了让t1先启动
        Thread.sleep(1000);
        t2.start();


    }
}

class MyThread01 implements Runnable{

    private MyClass myClass = null;
    public MyThread01(MyClass myClass){
        this.myClass = myClass;
    }
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("t1")){
            myClass.doSome();

        }
        else{
            myClass.doOther();
        }

    }
}
class MyClass{
    //实例方法doSome添加synchronized关键字
    public synchronized void doSome(){
        System.out.println("doSome begin");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }
    public void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }

}
