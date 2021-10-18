package jiangjie4;

import jiangjie2.Order;

/*
对属性可以赋值的位置:
1.默认初始化
2.显式初始化
3.构造器中初始化
4.有了对象以后，可以通过“对象.属性”或“对象.方法”的方式，进行赋值
5.在代码块中赋值
执行的先后顺序:1->2/5->3->4(2和5要看谁写在前面，谁就先执行)
 */
public class OrderTest {
    public static void main(String[] args) {
        Order1 order1=new Order1();
        Order2 order2=new Order2();
        System.out.println(order1.age);//显式初始化在前，显式初始化先执行
        System.out.println(order2.age);//代码块在前，代码块先执行
    }

}
class Order1{
    int age=1;
    {
        age=2;
    }
}
class Order2{
    {
        age=2;
    }
    int age=1;
}