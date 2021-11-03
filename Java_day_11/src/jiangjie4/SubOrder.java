package jiangjie4;
import jiangjie3.Order;
//在不同包的子类中，不能调用Order类中声明为private和缺省权限的属性和方法。
public class SubOrder extends Order {
    public void method()
    {
        //orderPrivate=1;
        //orderDefault=2;
        orderProtected=3;
        orderPublic=4;
        //methodPrivate;
        //methodDefault();
        methodProtected();
        methodPublic();
    }
}
