package com.cao.lambda;

public class LambdaTest01 {
    public static void main(String[] args) {
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
        Runnable r = () -> System.out.println("Lambda-hello");
        Thread t = new Thread(r);
        t.start();
    }
}
