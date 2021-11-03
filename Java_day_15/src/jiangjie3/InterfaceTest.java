package jiangjie3;

/*
接口的使用:
1.接口使用interface来定义
2.java中，接口和类是并列的两个结构
3.如何定义接口:定义接口中的成员
   3.1 JDK7及以前:只能定义全局变量和抽象方法
        3.1.1  全局变量:public static final。但是书写是，可以省略不写，默认接口中的变量为全局变量(可以直接通过接口.变量的形式进行调用）
        3.1.2 抽象方法:public abstract。
   3.2 JDK8:除了定义全局变量和抽象方法外，还可以定义静态方法和默认方法（略）。
4.接口中不能定义构造器，这意味着接口不可以进行实例化。
5.java开发中，接口通过让类去实现（implements）的方式来使用。
  如果实现类覆盖了类接口中的所有抽象方法，则此实现类就可以实例化。
  如果实现类没有覆盖类接口中的所有抽象方法，则此实现类仍为一个抽象类，不可以实例化。
6.java类中可以实现多个接口--->弥补了java单继承性的局限性
   格式:class AA extends BB implements CC,DD,EE
7.接口与接口之间可以继承，可以可以多继承
**************************************************************************************************************
8.接口的具体使用体现多态性。
9.接口实际上可以看做是一种规范。
面试题:抽象类和接口的异同:

 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        //Flyable.MIN_SPEED=2;
    }
}
interface Flyable {
    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    int MIN_SPEED = 1;//省略了public static final

    //抽象方法
    public abstract void fly();

    //省略了public abstract
    void stop();
    //Interfaces cannot have constructors
    //public Flyable(){
    //
    //}
}
class Plane implements  Flyable{
    public void fly(){
        System.out.println("通过引擎起飞");
    }
    public void stop(){
        System.out.println("驾驶员减速停止");
    }
}
//abstract class Kite implements Flyable{
//    public void fly{
//        System.out.println("通过风飞起来");
//   }
//}
interface Attacks{
    void attack();
}
class Bullet extends Object implements  Attacks,Flyable,CC{


    @Override
    public void fly() {
        System.out.println("在空气中飞");
    }

    @Override
    public void stop() {
        System.out.println("打到东西停");

    }

    @Override
    public void attack() {
        System.out.println("很疼");

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}
interface AA{
        void method1();
}
interface BB{
        void method2();
}
interface CC extends AA,BB{

}