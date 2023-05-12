package com.cao.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("曹留欣");
        list.add("dx");
        Class clazz = Class.forName("java.util.ArrayList");
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list,123);
        System.out.println(list);
    }
}
