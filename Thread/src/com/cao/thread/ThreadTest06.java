package com.cao.thread;

/**
 * sleep方法的一个思考
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        //创建一个线程对象
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //这行代码10秒之后会执行
                System.out.println(Thread.currentThread().getName() + "--->");
            }
        });
        //启动线程
        t.start();
        try {
            /*
                思考：我在这里用t调用sleep方法是让t线程休眠5秒还是主线程休眠5秒？
                    主线程会休眠5秒：因为sleep是一个静态方法，静态方法和对象没有一点关系
                    这段代码到最后还是会转变成：Thread.sleep(1000 * 5 );
                    这行代码出现在哪main方法中，只会让main线程休眠
             */
            t.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5秒之后会执行这行代码
        System.out.println(Thread.currentThread().getName() + "--->" );

    }
}
