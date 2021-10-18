package jiangjie2;

public class Bank {
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象
    //4.要求此对象也必须声明为静态的
    private static Bank instance=new Bank();
    //3.提供公共的静态的方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
