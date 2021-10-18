package jiangjie1;

import org.junit.Test;

import java.io.*;
/*
对象流的使用
1.ObjectInputStream和ObjectOutputStream
2.作用:用于存储和读取基本数据类型数据或对象的处理流。
3.要想一个java对象是可序列化的，需要满足相应的条件，具体看Person类的声明
4.序列化机制:对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存
在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
 */
/*
ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
这个很好理解，static表示静态变量是这个类共享的变量，自然不能让这个类其中的一个对象将其序列化，
即直接对对象实例序列化是不包括静态成员的。而transient就是标记一个成员变量不参与序列化过程。
 */
/*
谈谈你对java.io.Serializable接口的理解，我们知道它用于序列化，是空方法接口，还有其它认识吗？
1.实现了Serializable接口的对象，可将它们转换成一系列字节，并可在以后完全恢复回原来的样子。
这一过程亦可通过网络进行。这意味着序列化机制能自动补偿操作系统间的差异。换句话说，
可以先在Windows机器上创建一个对象，对其序列化，然后通过网络发给一台Unix机器，然后在那里
准确无误地重新“装配”。不必关心数据在不同机器上如何表示，也不必关心字节的顺序或者其他任何细节。
2,由于大部分作为参数的类如String、Integer等都实现了java.io.Serializable的接口，也可以利用多态的性质，作为参数使接口更灵活。
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化过程:将内存中的java对象保存到磁盘中或通过网络传播出去
            使用ObjectOutputStream实现
 */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream  oos=null;
        try{
        oos=new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("夜雨声烦黄少天"));
        oos.flush();//刷新操作
        oos.writeObject(new Person("黄少天",20));
        oos.flush();
        oos.writeObject(new Person("苏沐橙",19,new Account(10202)));
        oos.flush();}catch (IOException e){
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    /*
    反序列化:将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj=ois.readObject();
            String str=(String) obj;
            Person person1=(Person) ois.readObject();
            Person person2=(Person)ois.readObject();
            System.out.println(str);
            System.out.println(person1);
            System.out.println(person2);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
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
/*
Person需要满足如下的要求，方可序列化:
1.需要实现接口:Serializable(此接口内部没有任何的方法，是一个标识接口，所以在Person类中也不用实现任何方法)
2.当前类提供一个全局常量(public static final long ):serialVersionUID
   如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，
    serialVersionUID 可能发生变化。故建议，显式声明。Java的序列化机制是通过在运行时判断类的serialVersionUID来验
   证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID
   进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。(InvalidCastException)
3.当前类除了需要实现Serializable接口之外，还必须保证其内部所有属性必须是可序列化的(默认情况下，基本数据
   类型可序列化，String和包装类这几个引用类型自己已经进行了序列化)
 */
class Person implements Serializable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public Person(String name, int age, Account account) {
        this.name=name;
        this.age=age;
        this.account=account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public static final long serialVersionUID=385252349230523L;
    private String name;
    private int age;
    private Account account;

}
class Account implements Serializable{
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance=balance;
    }

    public Account(double balance) {
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public static final long serialVersionUID=495903022L;

}

