package com.cao.lambda.function;

import org.junit.Test;

import java.util.function.Consumer;

public class MyFunctionalInterfaceTest {
    @Test
    public void test01(){
        MyFunctionalInterface m = () -> System.out.println("hello");
        m.method();
    }
}
