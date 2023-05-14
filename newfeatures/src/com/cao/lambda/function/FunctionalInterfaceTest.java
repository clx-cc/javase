package com.cao.lambda.function;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceTest {

    /*
        消费型接口：有形参，无返回值
     */
    @Test
    public void test01(){
        Integer age = 22;
        Consumer<Integer> c = param -> System.out.println(param);
        c.accept(age);
    }
    /*
        供给型接口：有返回值，无形参
     */
    @Test
    public void test02(){
        Supplier<Integer> s = () -> 22;
        Integer age = s.get();
        System.out.println(age);
    }
    /*
        函数式接口：有返回值，有形参
     */
    @Test
    public void test03(){
        
    }
}
