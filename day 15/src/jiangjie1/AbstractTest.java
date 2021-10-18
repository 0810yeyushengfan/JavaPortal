package jiangjie1;

/*
abstract关键字的使用
1.abstract:抽象的
2.abstr可以用来修饰的结构:类和方法。
3.abstract修饰类:抽象类
   3.1 此类不能实例化，
   3.2 抽象类中一定会有构造器，便于子类对象实例化时调用（涉及:子类对象实例化的全过程），
   3.3 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作。
4.abstract修饰方法:抽象方法
    4.1 抽象方法只有方法的声明，没有方法体
    4.2 包含抽象方法的类一定是一个抽象类，反之，抽象类中可以没有实例方法，
    4.3 若子类重写了父类中的所有的抽象方法后，此子类方可实例化。
          若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰，否则不能通过编译。
5.abstract使用上的注意点:
   5,1 abstract不能用来修饰:属性，构造器等结构。
   5.2 abstract不能用来修饰:5.2.1私有方法,因为私有方法不能被子类所重写。
                                                      5.2.2静态方法，因为abstract类的方法没有方法体，不能被调用（保证这一点的便是
                                                      abstract类不能实例化对象），但是stract方法能不创建对象直接调用类实现，
                                                      两者矛盾，因此不能修饰stract方法。
                                                      而且静态方法对于父类和子类中同名同参数的两个静态方法不算重写只是覆盖。
                                                      5.2.3final修饰的方法，因为final修饰的方法天然的不能被重写，而抽象方法必须被重写。
                                                      5.2.4final修饰的类，因为final修饰的类天然的不能被继承，而抽象类必须被继承。
 */
public class AbstractTest {
    public static void main(String[] args) {
        //一旦Person类抽象了，就不可实例化
        //Person p1=new Person();
        //p1.eat();

    }
}
abstract class Creature{
    public abstract void  breath();
}
abstract class Person extends Creature{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //不是抽象方法
    //public void eat(){
    //
    //}

    //抽象方法
    public abstract void eat();
    public void walk(){
        System.out.println("人走路");
    }
}
class  Student  extends Person{//或者不重写抽象方法，将Student声明为abstract，也能通过编译
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }
    public void eat(){
        System.out.println("学生多吃有营养的食物");
    }
    public void breath(){
        System.out.println("学生应该呼吸新鲜空气");
    }
}