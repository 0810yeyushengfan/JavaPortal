package jiangjie2;
/*
单例模式的懒汉式实现
之所以叫懒汉式，是因为最初在声明当前类的对象，没有进行初始化，new一个新的对象，只是赋值为null，所以很懒。
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order order1=Order.getInstance();
        Order order2=Order.getInstance();
        System.out.println(order1==order2);//true  证明order1与order2是同一个对象
    }
}
