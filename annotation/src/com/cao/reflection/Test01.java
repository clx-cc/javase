package com.cao.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//什么叫反射
public class Test01 {

    public static void main(String[] args) throws Exception {
        Person person = new Student();
//        System.out.println(person.name.hashCode());
        Class<?> c1 = Class.forName("com.cao.reflection.Person");
        Class<Student> c2 = Student.class;

        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------");
        Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

}

//实体类  pojo
class Person{
    public String name;
    private int age;
    private int id;
    protected int num;

    public Person() {
    }
    private Person(String name){

    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
    private void say(String name ,Integer age){

    }
}
class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "学生";
    }
}
