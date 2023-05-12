package com.cao.thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用java.util.Timmer定时器
 */
public class ThreadTest13 {
    public static void main(String[] args) throws Exception {
        //创建一个Timmer定时器
        Timer timmer = new Timer();
        //设置第一次开始执行时间
        //设置第一次执行时间2022-10-02 9：58：00
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2022-10-02 9:58:00");

        //调用schedule方法设置定时器
        //timmer.schedule(TimerTask task,Date firstTime ,long period);
        //使用匿名内部类实现定时任务
        timmer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这个定时器的作用是每隔10秒输出一次这句话");
            }
        },firstTime,1000 * 10);
    }
}
