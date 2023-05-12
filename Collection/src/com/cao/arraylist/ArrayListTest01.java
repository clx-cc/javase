package com.cao.arraylist;

import java.util.Arrays;

public class ArrayListTest01 {
    public static void main(String[] args) {
        //创建对象数组
        Student[] students = {
          new Student("小明",18),
          new Student("小李",19),
          new Student("小刚",20)
        };
        //将其赋值给Object对象数组
        Object[] objects = students;

        //原对象数组的数组类型：Lcom.cao.arraylist.Student;
        System.out.println(students.getClass());

        //执行if语句前，打印原对象数组的class（也就是数组类型：Lcom.cao.arraylist.Student;）
        System.out.println("原对象数组的数组类型：" + objects.getClass());

        //执行以下代码：将原对象数组的数组类型转化为Object对象数组的数组类型。以便更好存储。
        //转化为：[Ljava.lang.Object;
        if (objects.getClass() != Object[].class){
            objects = Arrays.copyOf(objects,objects.length,Object[].class);
        }

        //执行if后，打印数组的class
        System.out.println("执行完if转化之后对象数组的数组类型：" + objects.getClass());

    }
}
class Student{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
