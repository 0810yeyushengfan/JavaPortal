package review1;
/*
在局部内部类的方法中（比如show），如果调用局部内部类所声明的方法（比如method）
在jdk7及以前的版本中，要求此局部变量显式的声明为final的中的局部变量
比如（num），要求此局部变量声明为final的。可以从生命周期的角度理解这件事,内部类和外部类是两个不同的类，
在内部类中使用外部类的局部变量，在生命周期中传递这个变量很困难，所以实际上是使用外部类局部变量的一个副本，
因此只能对此变量进行调用和不能进行修改，所以显式的声明为final变量。
jdk8之后的版本，可以省略final的声明。
 */
public class InnerClass {
   public void method(){
       //局部变量
       int num=10;//省略了final
       class AA{
           public void show(){
               //num=20;//不能被更改
               System.out.println(num);
           }
       }
       //num=20;//不能被更改
   }

}
