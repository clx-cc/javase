package com.cao.exam02;

/**
 * 思考2：t1和t2线程共享同一个MyClass实例，在这个以实例中有两个实例方法：doSome和doOther
 *  问：
 *      给doSome方法和doOther方法都添加关键字synchronized，当t1线程执行run方法，调用doSome方法时
 *      t2线程进入执行run方法，调用实例方法doOther,请问t2线程需要等待t1线程执行结束吗？
 *  答：
 *      需要，因为t1和t2共享这个实例对象，耐用这个对象的两个实例方法都添加了synchroinzed关键字，共享对象是this,
 *      当t1执行doSome时占用这个this（共享对象）的锁，此时t2再想去执行this的doOther方法发现锁已经被占用，只能等待
 *      锁被释放的时候才可以去执行。
 */
public class Exam02 {
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
    //实例方法doOhter添加synchronized关键字
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }

}
