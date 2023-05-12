package com.cao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解

public class test03 {

    //注解可以显示赋值，如果没有默认值，我们必须给注解赋值
    @MyAnnotation2
    public static void main(String[] args) {

    }

}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

    //注解的参数：参数类型+参数名()
    //定义了参数不写参数，会报错，可以给参数一个默认值
    String name() default "";

}
