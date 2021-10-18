package jiangjie6;

import java.sql.Connection;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test=new AnimalTest();
        test.func(new Dog());
        test.func(new Cat());
    }
    //举例一:
    public void func(Animal animal)//Animal animal=new Dog()=new Cat()
    {
        animal.eat();
        animal.shout();
    }
    //public void func(Dog dog)
    //{
    //    dog.eat();
    //    dog.shout();
    //}
    //public void func(Cat cat)
    //{
    //    cat.eat();
    //    cat.shout();
    //}
}
class Animal{
    public void eat()
    {
        System.out.println("动物。进食");
    }
    public void shout()
    {
        System.out.println("动物，喊叫");
    }
}
class Dog extends Animal{
    public void eat()
    {
        System.out.println("狗吃骨头");
    }
    public void shout()
    {
        System.out.println("汪！汪！汪！");
    }
}
class Cat extends Animal{
    public void eat()
    {
        System.out.println("猫吃鱼");
    }
    public void shout()
    {
        System.out.println("喵！喵！喵！");
    }
}
//举例二:
class Order{
    public void method(Object obj)
    {

    }
}
//举例三:
class Driver{
    public void doData(Connection conn)//conn =new MySQlConneaction();/conn =new OracleConnection()
    {
        //规范的步骤去发操作数据
        //conn.method1();
        //conn.method2();
        //conn.method3();
    }
}