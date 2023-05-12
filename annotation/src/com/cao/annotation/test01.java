package com.cao.annotation;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class test01 {
    public static void main(String[] args) {
         test();
        List list = new ArrayList();
    }

    @Deprecated
    private static void test() {
        System.out.println("DEPRECATED");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
