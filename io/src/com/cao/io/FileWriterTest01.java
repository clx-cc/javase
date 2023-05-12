package com.cao.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//文件字符输出流
public class FileWriterTest01 {
    public static void main(String[] args) {
        //File类的实例化，指出写出到的文件
        File file = new File("E:\\clx\\java\\IOTest\\filewritertest.txt");
        //提供FileWriter流对象，用于写出数据
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,false);
            fw.write("I am a chinese! I love China!");
            fw.write("\nhello world");
            fw.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
                try {
                    fw.close();//关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
