package jiangjie4;
import java.util.Date;
import javax.imageio.stream.ImageInputStream;

/*
Object类中toString类的使用。
1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString。
2.Object类中toString（）的定义。
  public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
3.像String，Date，File，包装类等都重写了Object类中的toString()方法。使得在调用toString（）方法时，返回”实体内容“信息。
4.自定义类也可以重写toString方法，当调用此方法时，返回对象的”实体内容“。
 */
public class ToStringTest {
    public static void main(String[] args) {
        Customer cust1=new Customer(21,"Tom");
        System.out.println(cust1.toString());//jiangjie4.Customer@14ae5a5->Customer[name = Tom,age = 21]
        System.out.println(cust1);//jiangjie4.Customer@14ae5a5->Customer[name = Tom,age = 21]
        String str=new String("MM");
        System.out.println(str);//MM
        System.out.println(str.toString());//MM
        Date date=new Date(31481384L);
        System.out.println(date.toString());//Thu Jan 01 16:44:41 CST 1970


    }
}
