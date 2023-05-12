package com.cao.thread;

/**
 * sleep方法	public static void sleep(long millis)
 * - 这是一个静态方法
 * - 参数是毫秒值
 * - 作用：让当前线程进入“阻塞状态”，暂时归还cpu时间片，让给其他线程使用。
 */
public class ThreadTest05 {
    public static void main(String[] args) {

//        try {
//            //让主线程休眠5秒
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //下面这行代码会5秒后执行
//        System.out.println("5秒后的我");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
