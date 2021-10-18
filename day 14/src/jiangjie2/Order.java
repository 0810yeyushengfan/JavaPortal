package jiangjie2;

public class Order {
    //1.私有化类的构造器
    private Order(){

    }
    //2.声明当前类的对象，没有初始化
    //4.此对象也必须声明为static的
    private static Order instance=null;
    //3.提供公共的静态的方法，返回类的对象
    public static Order getInstance(){
        if(instance==null)
        {
            instance=new Order();
        }
            return instance;
    }
}
