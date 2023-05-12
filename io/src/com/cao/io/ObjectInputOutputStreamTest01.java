package com.cao.io;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest01 {
    /**
     * 使用ObjectOutputStream实现序列化。将内存中的java对象保存到文件中或者通过网络传输
     */
    @Test
    public void testOutputStream(){
        //创建对象
        File file = new File("E:\\clx\\java\\IOTest\\object.txt");
        ObjectOutputStream oos = null;
        try {
             oos = new ObjectOutputStream(new FileOutputStream(file));
             //序列化（将String类型的数据保存到文件中）
             oos.writeUTF("序列化过程，，，，，，");
             oos.flush();
             //序列化普通对象
             oos.writeObject("我是一个普通的对象。。。。。。。。");
             oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    /**
     * 使用ObjectInputStream实现反序列化。将文件中的数据还原成java对象
     */
    @Test
    public void ObjectInputStream(){
        //创建对象
        File file = new File("E:\\clx\\java\\IOTest\\object.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            //反序列化过程（读取文件中的对象）
            String s = ois.readUTF();
            System.out.println(s);
            String str = (String) ois.readObject();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //演示自定义类的对象的序列化和反序列化
    //序列化过程：
    @Test
    public void test03(){
        //创建对象
        File file = new File("E:\\clx\\java\\IOTest\\object2.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            //序列化过程（将自定义类型的数据保存到文件中）
            Person tom = new Person("tom", 222);
            oos.writeObject(tom);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //反序列化过程
    @Test
    public void test04(){
        //创建对象
        File file = new File("E:\\clx\\java\\IOTest\\object2.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            //反序列化过程（读取文件中的对象）
            Person tom = (Person) ois.readObject();
            System.out.println(tom);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Person implements Serializable{//Serializable：属于标识接口
    //所有属性必须是可序列化的
    private String name;
    int age;
    //定义一个全局常量，是这个类的一个标识
    private static final long serialVersionUID = 1241231274726387423L;
    @Override
    public String toString() {
        return "Person{" +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

