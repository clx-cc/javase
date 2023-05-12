package com.cao.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test07 {
    public static void main(String[] args) throws Exception {
        Class user = Class.forName("com.cao.reflection.User");
        //通过反射获得注解
        Annotation[] annotations = user.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        TableUser tableuser = (TableUser)user.getAnnotation(TableUser.class);
        String value = tableuser.value();
        System.out.println(value);

        //获得类的属性的注解并打印它的值
        Field name = user.getDeclaredField("name");
        FieleUser annotation = name.getAnnotation(FieleUser.class);
        System.out.println(annotation.colName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }

}

@TableUser("db_User")
class User{
    @FieleUser(colName = "db_id",type = "int",length = 10)
    private int id;
    @FieleUser(colName = "db_name",type = "varchar",length = 20)
    private String name;
    @FieleUser(colName = "db_age",type = "int",length = 10)
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableUser{
    String value();
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieleUser{
    String colName();
    String type();
    int length();
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodUser{

}
