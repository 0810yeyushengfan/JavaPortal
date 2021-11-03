package jiangjie5;
/*
类的内部成员之五:内部类
1.java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类。
2.内部类的分类:成员内部类（静态，非静态） vs 局部内部类（方法内，代码块内，构造器内）
3.成员内部类:
   3.1  一方面，作为外部类的成员:
                     3.1.1能调用外部类的结构
                     3.1.2可以被static修饰
                     3.1.3可以被四种不同的权限修饰
   3.2 另一方面，作为一个类:
         3.2.1 类内可以定义属性，方法，构造器等
         3.2.2 可以被final修饰，表示此类不能被继承 ，言外之意，不使用final的内部类就可以被继承
         3.2.3 可以被abstract修饰，表示不能进行实例化
4.关注如下的三个问题:
    4.1 如何实例化成员内部类的对象
    4.2 如何在成员内部类中区分调用外部类的结构
    4.3 开发中局部内部类的使用(见InnerClassTest)
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        Person.Dog dog=new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）
        //Person.Bird bird=new Person.Dog();错误的写法
        Person p=new Person();
        Person.Bird bird=p.new Bird();//因为如果Person类中有个属性为Bird类的话，p.Bird()即为调用Person p中的属性类Bird，所以不能创建内部类不能写成new p.Bird()，而应该是p.new Bird(),先把p中的内部类new出来，再调用赋值
        bird.sing();
    }
}
class Person{
    String name;
    int age;
    Bird birds;
    public void eat(){
        System.out.println("人吃饭");
    }
    //静态成员内部类
    static class Dog{
        String name;
        int age;
        public void show(){
            System.out.println("卡拉是条狗");
            //eat();
        }
    }
    //非静态成员内部类
    public class Bird{
        String name;
        public Bird(){

        }
        public void sing(){
            System.out.println("我是一只鸟");
            Person.this.eat();//调用外部类的非静态属性/方法
            eat();//省略的是Person.this.eat()
        }
        public void display(String name){
            System.out.println(name);//输出的是方法的形参的name
            System.out.println(this.name);//输出的是内部类的属性name
            System.out.println(Person.this.name);//输出的是外部类的属性name
        }
    }
}
