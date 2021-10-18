package test3;

public class OrderTest {
    public static void main(String[] args) {
        Order order1=new Order(1001,"AA");
        Order order2=new Order(1001,"BB");
        Order order3=new Order(1001,"BB");
        Order order4=new Order(1001,new String("BB"));
        System.out.println(order1.equals(order2));//false
        System.out.println(order2.equals(order3));//true。要注意，如果用错误的方法执行这个语句，得到的结果也是true
        //这是因为String存储在常量池中，一旦有一个已经声明过的String，它存储在常量池中，
        //然后再声明了一个内容相同的String，它同样指向常量池中与它内容相同的地址。
        //即当String s1="BB";
        //   String s2="BB";
        //   System.out.println(s1==s2);这个语句的结果是true
        System.out.println(order2.equals(order4));//true,此时若用错误的方法执行这个语句，会得到false。
    }
}
