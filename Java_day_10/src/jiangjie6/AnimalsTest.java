package jiangjie6;
/*
面向对象的特征一:封装和隐藏
一.问题的引入
  当我们创建一个类的对象以后，我们可以通过“对象.属性”的方式对对象的属性赋值。这里赋值操作要受到属性的数据类型和存储范围的制约，
  除此之外，没有其他制约条件。但是在实际问题当中，我们往往需要给属性赋值加入额外的限制条件，这个条件就不能在属性声明时体现。
  我们只能通过方法进行限制条件的添加。（比如setLegs（））。同时我们需要避免用户再使用“对象.属性“的方式对属性进行赋值，
  则需要将属性声明为私有的（private）。此时，针对于属性就体现了封装性。
二.封装性的体现
1.我们将类的属性xxx私有化（private），同时提供公共的（public）方法来获取（get（））和设置（set（））私有的属性。
2.不对外暴露的私有的方法。
3.单例模式......
三.封装性的体现，需要权限修饰符来配合
1.java规定的四种权限（从小到达排列）
private<缺省（default）<protected<public
分别对应的访问权限为类内部<同一个包内<不同包的子类<同一个工程
2.四种权限可以用来修饰类和类的内部结构:属性，方法，构造器，内部类
  具体的，四种权限可以用来修饰类的内部结构:属性，方法，构造器，内部类
         修饰类的话。只能用缺省和public
3.总结封装性:java提供了四种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在调用时的可见性的大小
 */
public class AnimalsTest {
    public static void main(String[] args) {
        Animals a=new Animals();
        a.name="大黄";
        a.age=1;
       //a.legs=4;
        a.setLegs(4);
        a.show();
        //a.legs=-4;//在Animals类中限制只允许对legs赋值正确合理的数是很困难的，因此要引入封装性
        a.setLegs(-4);
        a.show();
    }
}