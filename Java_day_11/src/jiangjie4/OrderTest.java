package jiangjie4;
//不同包下的普通类（非子类）要使用Order类，不可以调用声明为private，缺省和protected权限的属性和方法。
public class OrderTest {
    public static void main(String[] args) {
        jiangjie3.Order order=new jiangjie3.Order();
        //order.orderPrivate=1;
        //order.orderDefault=2;
        //order.orderProtected=3;
        order.orderPublic=4;
        //order.methodPrivate;
        //order.methodDefault();
        //order.methodProtected();
        order.methodPublic();
    }

}
