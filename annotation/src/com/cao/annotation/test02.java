package com.cao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//测试元注解
//@MyAnnotation
public class test02 {
    @MyAnnotation
    public static void main(String[] args) {

    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

}
