package com.cao.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//日志工具
public class logUtil {
    private logUtil() {
    }
    //记录日志的方法
    public static void log(String msg){
        PrintStream ps = null;
        try {
            //将文件输出流设置为追加
             ps = new PrintStream(new FileOutputStream(new File("E://log.txt"),true),true);
             //改变输出方向
            if (ps != null){
                System.setOut(ps);
            }
            //日期时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm SSS");
            //格式化当前日期
            String nowDate = sdf.format(new Date());
            //打印日志
            System.out.println(nowDate + ":" +msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
