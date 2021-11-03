package jiangjie4;
/*
类的成员之四:代码块（或初始化块）。
1.代码块的作用:用来初始化类，对象。
2.代码块如果有修饰的话，只能用static。
3.分类:静态代码块 vs 非静态代码块。
4.静态代码块:
  4.1内部可以有输出语句。
  4.2随着类的加载而执行，而且只会执行一次。
  4.3如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行。但是定义多个静态代码块没有必要，可以合并。
  4.4静态代码块的执行一定优于非静态代码块的执行。
  4.5静态代码块只能调用静态的属性和方法，不能调用非静态的结构。
5.非静态代码块:
  5.1内部可以有输出语句。
  5.2随着对象的创建而执行，而且每创建一次对象都会执行一次。(对象的创建即为构造器的执行)
  5.3作用:可以在创建对象时，对对象的属性等进行初始化。
  5.4如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行。但是定义多个非静态代码块没有必要，可以合并。
  5.5非静态代码块可以调用静态的属性和方法，也能调用非静态的属性和方法。
对属性可以赋值的位置:
1.默认初始化
2.显式初始化
3.构造器中初始化
4.有了对象以后，可以通过“对象.属性”或“对象.方法”的方式，进行赋值
5.在代码块中赋值
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc=Person.desc;
        System.out.println(desc);
        Person p1=new Person();
        Person p2=new Person();
        System.out.println(p1.age);
        Person.info();
    }
}
class Person{
    //属性
    String name;
    int age;
    static String desc="我是一个人";
    //构造器
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //static的代码块
    static {
        System.out.println("hello,static block-1");
        desc="我是一个好人";
    }
    static {
        System.out.println("hello,static block-2");
        desc="我是一个好人";
    }
    //非static的代码块
    {
        System.out.println("hello block-1");
        //调用非静态结构
        age=1;
        eat();
        //调用静态结构
        desc="我是一个好人";
        info();

    }
    {
        System.out.println("hello block-2");
        age=1;
    }
    //方法
    public void eat(){
        System.out.println("人吃饭");
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void info(){
        System.out.println("我是一个快乐的人");
    }
}