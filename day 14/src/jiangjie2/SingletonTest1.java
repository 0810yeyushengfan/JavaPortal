package jiangjie2;
/*
单例设计模式:
1.所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
2.单例设计模式的分析:
如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构 造器的访问权限设置为private，这样，就不能用new操作符在类的外部
产生类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，
静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象的变量也必须定义成静态的。
3.如何实现？
  饿汉式vs懒汉式
4.区分饿汉式和懒汉式
  饿汉式:
        坏处:对象加载时间过长。
        好处:饿汉式是线程安全的。
   懒汉式:
        好处:延迟对象的创建。
        目前的写法坏处:线程不安全。--->到多线程内容时，再修改。

 */
/*
单例模式的饿汉式实现
之所以叫饿汉式，是因为最初在声明当前类的对象，立刻进行了初始化，new了一个新的对象，很快，所以很饿。。
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();
        System.out.println(bank1==bank2);//true  证明bank1与bank2是同一个对象
        
    }
}

