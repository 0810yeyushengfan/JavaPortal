package jiangjie6;

import java.util.Date;

/*
面向对象特征之三:多态性
理解多态性:可以理解为一个事物的多种形态。
1.理解多态性:可以理解为一个事物的多种形态。
2.何为多态性:
  对象的多态性:父类的引用指向子类的对象（或子类的对象赋给父类的引用）
3.多态的使用:虚拟方法调用
  有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法，
  总结:编译看左边，运行看右边。
4.多态性的使用前提:
  4.1类的继承关系
  4.2方法的重写
5.对象的多态性:只适用于方法，不适用于属性（属性的编译和运行都看左边）
6.多态是编译时行为还是运行时行为
  多态是典型的运行时行为。
7.方法的重载和重写在编译和运行的角度的区别
  重载:是指允许存在多个同名方法，而这些方法的参数不同，编译器根据方法不同的参数表，对同名方法的名称做修饰。
      对于编译器而言，这些同名方法就成了不同的方法，它们的调用地址在编译期就绑定了，java的重载是可以包括
      父类和子类的，即子类可以重载父类的同名不同参数的方法。
  所以，对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这称为”早绑定“或”静态绑定“。
  而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体方法，这称为”晚绑定“或者”动态绑定“。
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
        p1.eat();
        Man man=new Man();
        man.eat();
        man.age=25;
        man.earnMoney();
        System.out.println("*******************");
        //对象的多态性:父类的引用指向子类的对象
        Person p2=new Man();
        Person p3= new Woman();
        //多态的使用:当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
        p2.eat();
        p2.walk();
        // 无法调用父类中不存在而子类中特有的方法和属性,因为编译时，p2是Person类型。
        // p2.earnMoney();
        // p2.isSmoking=true;
        System.out.println(p2.id);//1001
        System.out.println("******************");
        /*
          有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，
          导致编译时只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用。
          如何才能调用子类特有的属性和方法呢？
          向下转型:使用强制类型转换符。
        */
        Man m1=(Man)p2;
        m1.earnMoney();
        m1.isSmoking=true;
        //使用强制类型转换时，可能会出现ClassCastException的异常
        //Woman w1=(Woman)p2;
        //w1.goShopping();
        /*
          instanceof关键字的使用:
          a instanceof A:判断对象a是否是类A的实例，如果是，返回true，如果不是，返回false。
          使用情境:
          为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先进行instanceof的判断，
          如果返回true，就进行向下转型，如果返回false，则不能进行向下转型。
      */
        if(p2 instanceof Man)
        {
            Man m2=(Man)p2;
            m2.earnMoney();
            m2.isSmoking=true;
            System.out.println("**********Man**********");
        }
        if(p2 instanceof Person)
        {
            System.out.println("**********Woman**********");
        }
        if(p2 instanceof Object)
        {
            System.out.println("**********Object**********");
        }
        //练习
        //问题一:编译时通过，运行时不通过
        //Person p3=new Woman();
        //Man m3=(Man)p3;
        //Person p4=new Person();
        //Man m4=(Man)p4;
        //问题二:编译时通过，运行时也通过
        //Object obj=new Woman();
        //Person p=(Person)obj;
        //问题三:编译不通过
        //Man m5=new Woman();
        //String str=new Date();
        //以下做法可以骗过编译器通过编译，但是并没有什么用
        //Object o=new Data();
        //String str1=(String)o;

    }
}
