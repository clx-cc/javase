package com.cao.io;

import java.io.*;

//使用字符缓冲流进行文本文件的复制
public class CopyByBufferedReaderAndBufferedWriter {
    public static void main(String[] args) {
        //实例化缓冲流对象
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("E:\\clx\\java\\IOTest\\copy.txt")));
            bw = new BufferedWriter(new FileWriter(new File("E:\\clx\\java\\IOTest\\copy6.txt")));
            //使用数组一次读取多个字节
            /*char[] ubuf = new char[1024];
            int len;
            while ((len = br.read(ubuf)) != -1){
                bw.write(ubuf,0,len);
                bw.flush();
            }*/
            //使用readLine方法一次读取一行
            String str = null;
            while ((str = br.readLine()) != null){//读取完毕返回null
                bw.write(str);
                bw.write("\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
