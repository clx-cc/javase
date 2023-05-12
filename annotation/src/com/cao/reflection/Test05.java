package com.cao.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //获得Class对象
        Class<?> c1 = Class.forName("com.cao.reflection.Person");

        Constructor<?> constructor = c1.getDeclaredConstructor();
        Object obj1 = constructor.newInstance();
        Field name = c1.getDeclaredField("id");
        name.setAccessible(true);
        name.set(obj1,1111);
        System.out.println(obj1);

    }
}
