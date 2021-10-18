package jiangjie3;
//同一个包中的其他类，不可以调用Order类中的属性和方法。
public class OrderTest {
    public static void main(String[] args) {
        jiangjie3.Order order=new jiangjie3.Order();
        //order.orderPrivate=1;
        order.orderDefault=2;
        order.orderProtected=3;
        order.orderPublic=4;
        //order.methodPrivate;
        order.methodDefault();
        order.methodProtected();
        order.methodPublic();

    }

}
