package jiangjie5;


/*
1.final 可以用来修饰的结构:类，方法，变量。
2.final 用来修饰一个类:此类不能被其他类所继承
        比如String类，System类，StringBuffer类。
3.final 用来修饰方法:此方法不能被重写。
        比如Object类中的getClass();
4.final 用来修饰变量:此时的“变量”就是一个常量。
  4.1 final修饰属性:可以考虑赋值的位置:显式初始化，代码块中初始化，构造器中初始化。
                   final属性只是一个简单的常量值，而且每个对象都一样，不会变化--->显式初始化
                   final属性不是简单的一个值，而是调用了一个方法，而且方法可能会抛异常，需要处理--->代码块中初始化
                  每个对象的final属性的值都不一样，final的属性值会变化--->构造器中初始化
  4.2 final修饰局部变量:在方法体内部使用final修饰变量，只是简单的将其变为了常量，不可以再修改，只能使用。
                      尤其是使用fianl修饰形参时，表明此形参是一个变量，当我们调用此方法时，给常量形参赋一个实参，
                      一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值，
  4.3 static final:用来修饰属性，表示为全局常量，接口中常用。
 */
public class FinalTest {
    final int WIDTH=0;
    final int LEFT;
    final int RIGHT;
    //final int DOWN;//没有默认初始化
    {
        LEFT=1;
    }
    public FinalTest(){
        RIGHT=2;
    }
    public FinalTest(int n){
        RIGHT=n;
    }
    //public void setDown(int DOWN){//也不能用方法进行赋值
    //    DOWN=3;
    //}
    //public void doWidth(){
    //    WIDTH=20;
    //}
    public void show()
    {
        final  int NUM=10;//常量
        //NUM+=5;

    }
    public void show(final  int NUM)
    {
        //NUM=20;
        //NUM+=5;
    }
    public static void main(String[] args) {
        int num=10;
        num+=5;
        final int NUM=10;
        //NUM+=5;
        FinalTest test=new FinalTest();
        test.show(10);
    }
}
final class finalA{

}
//class B extends finalA{  //编译报错
//
//}
//class C extends String{  //编译报错
//
//}
class AA{
    public final void show(){

    }
}
class BB extends AA{
    //public void show(){  //编译报错
    //
    //}
}