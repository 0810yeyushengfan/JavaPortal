package jiangjie3;
/*
main（）方法的使用说明:
1.main（）方法作为程序的入口。
2.main（）方法也是一个普通的静态方法。
3.main（）方法也可以作为我们与控制台交互的一种方式（之前都是使用Scanner）。
4.main（）方法的具体解析:
  4.1 由于Java虚拟机需要调用类的main()方法，所以该方法的访问权限必须是public，
      又因为Java虚拟机在执行main()方法时不必创建对象，所以该方法必须是static的，
      该方法接收一个String类型的数组参数，该数组中保存执行Java命令时传递给所运行的类的参数.
  4.2 又因为main() 方法是静态的，我们不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后,
      才能通过这个对象去访问类中的非静态成员，这种情况，我们在之前的例子中多次碰到.
5.对main（）方法的总结:
public static void main(String args[]){//方法体}
权限修饰符:private 缺省 protected public ---->封装性
修饰符:static/final/abstract/native ---->可以用来修饰方法
返回值类型:无返回值/有

 */
public class MainTest {
}
