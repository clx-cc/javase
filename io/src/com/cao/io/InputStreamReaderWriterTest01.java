package com.cao.io;

import java.io.*;

//将utf-8的文本文件的编码改为gbk
public class InputStreamReaderWriterTest01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fis = new FileInputStream(new File("E:\\clx\\java\\IOTest\\test.txt"));
            fos = new FileOutputStream(new File("E:\\clx\\java\\IOTest\\test1.txt"));
            br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
            bw = new BufferedWriter(new OutputStreamWriter(fos,"GBK"));
            String str = null;
            while ((str = br.readLine()) != null){
                bw.write(str);
                bw.flush();
            }
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
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
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
