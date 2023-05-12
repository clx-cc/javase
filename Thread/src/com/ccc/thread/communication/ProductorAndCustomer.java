package com.ccc.thread.communication;

/**
 * 生产者与消费者：
 *
 */
public class ProductorAndCustomer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer target = new Producer(clerk);
        Consumer target2 = new Consumer(clerk);
        //创建线程对象
        Thread t1 = new Thread(target, "t1");
        Thread t2 = new Thread(target2, "t2");
        t1.start();
        t2.start();

    }
}
class Clerk{
    //规定只能放5个产品
    private int products = 0;

    //增加产品
    public synchronized void addProduct(){
        if (this.products >= 5){//停止生产
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            this.products++;
            System.out.println(Thread.currentThread().getName()+"生产了产品："+this.products);
            notify();
        }

    }
    //减少产品
    public synchronized void minusProduct(){

        if (this.products <= 0){//不能消费
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"消费了产品：" + this.products);
            this.products--;
            notify();
        }

    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
class Producer implements Runnable{//生产者
    //共享资源是店员手里的产品
    Clerk clerk = null;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
class Consumer implements Runnable{
    //共享资源是店员
    Clerk clerk = null;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.minusProduct();
        }
    }
}
