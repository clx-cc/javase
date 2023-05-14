package com.cao.reference;

import com.cao.reference.dao.Student;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    //情况一：对象 :: 实例方法
    @Test
    public void test01(){
        //原始方法
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("对象 :: 实例方法——普通");
        //2.lambda表达式
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("对象 :: 实例方法——lambda");
        //3.方法引用
        Consumer<String> con3 = System.out :: println;
        con3.accept("对象 :: 实例方法——方法引用情况一");
    }
    //情况一：对象 :: 实例方法
    //自定义类Student的getName方法
    @Test
    public void test02(){
        Student student = new Student("ccc", 22, "男");
        //普通
        Supplier<String> sup1 = new Supplier<String>() {
            @Override
            public String get() {
                return student.getName();
            }
        };
        System.out.println(sup1.get());
        //lambda表达式
        Supplier<String> sup2 = () ->  student.getName();
        System.out.println(sup2.get());
        //方法引用：对象::实例方法名
            //函数式接口的实现的实现方法的 形参列表和返回值类型 和Student对象的getName方法的 形参列表和返回值 类型一致。(String ())
        Supplier<String> sup3 = student :: getName;
        System.out.println(sup3.get());
    }
    //情况二：类 :: 静态方法
    //Comparator中的 int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test03(){
        //普通方式
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(12, 21));
        //lambda表达式方式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(12, 21));
        //方法引用：类 :: 静态方法
        Comparator<Integer> com3 = Integer :: compare;
        System.out.println(com3.compare(12, 21));
    }
    //情况三：类 :: 实例方法（难）
    //Comparator的compare方法
    //String中的compareTo方法
    @Test
    public void test04(){
        //普通方式
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare("abc", "abb"));
        //lambda表达式
        Comparator<String> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare("abc", "abb"));
        //方法引用：类 :: 实例方法
        Comparator<String> com3 = String :: compareTo;
        System.out.println(com3.compare("abc", "abb"));
    }
    //情况三
    @Test
    public void test05(){
        Student student = new Student("ccc", 22, "男");
        //普通
        Function<Student,String> fun1 = new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        };
        System.out.println(fun1.apply(student));
        //lambda表达式
        Function<Student,String> fun2 = student1 -> student.getName();
        System.out.println(fun2.apply(student));
        //方法引用
        Function<Student,String> fun = Student :: getName;
        System.out.println(fun.apply(student));
    }
    //构造器引用
        //案例一
    @Test
    public void test06(){
        //
        Supplier<Student> sup1 = new Supplier<Student>() {
            @Override
            public Student get() {
                return new Student();
            }
        };
        //构造器引用：调用的相当于是Student中的无参构造器
        Supplier<Student> sup2 = Student::new;
    }
    //构造器引用
        //案例2
    @Test
    public void test07(){
        //
        Function<Integer,Student> fun1 = new Function<Integer, Student>() {
            @Override
            public Student apply(Integer integer) {
                return new Student(integer);
            }
        };
        System.out.println(fun1.apply(22));
        //构造器引用：调用的相当于是Student中一个参数是Integer/int的构造器
        Function<Integer,Student> fun2 = Student::new;
        System.out.println(fun2.apply(22));
    }
    //构造器引用
        //案例三
    @Test
    public void test08(){
        //
        BiFunction<String,Integer,Student> bif1 = new BiFunction<String, Integer, Student>() {
            @Override
            public Student apply(String s, Integer integer) {
                return new Student(s,integer);
            }
        };
        System.out.println(bif1.apply("ccc", 22));
        //构造器引用：调用的相当于是Student中两个参数是Integer/int和String的构造器
        BiFunction<String,Integer,Student> bif2 = Student::new;
        System.out.println(bif2.apply("ccc",22));
    }
    //数组引用
    @Test
    public void test09(){
        //
        Function<Integer,Student[]> fun1 = new Function<Integer, Student[]>() {
            @Override
            public Student[] apply(Integer length) {
                return new Student[length];
            }
        };
        System.out.println(fun1.apply(5).length);
        //数组引用
        Function<Integer,Student[]> fun2 = Student[] :: new;
        System.out.println(fun2.apply(5).length);
    }
}
