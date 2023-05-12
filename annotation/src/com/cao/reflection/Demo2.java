package com.cao.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Apple apple1 = new Apple(500,"红富士");
        //定义一个方法可以将apple1对象中的name属性的值设置为value
        String value = "大苹果";
        setName(apple1,apple1.getName(),value);
        System.out.println(apple1);
    }
    public static void setName(Object obj,String name, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        Field name1 = clazz.getDeclaredField("name");
        name1.setAccessible(true);
        name1.set(obj,value);

    }

}

class Apple{
    private int weight;
    private String name;

    public Apple() {
    }

    public Apple(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
