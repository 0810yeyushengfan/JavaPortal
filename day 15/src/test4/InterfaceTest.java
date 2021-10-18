package test4;
/*
定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1=new ComparableCircle(3.4);
        ComparableCircle c2=new ComparableCircle(3.6);
        ComparableCircle c3=new ComparableCircle(3.4);
        ComparableCircle c4=new ComparableCircle(3.2);
        int compareValue1= c1.compareTo(c2);
        if(compareValue1>0)
            System.out.println("c1半径大");
        else if(compareValue1==0)
            System.out.println("一样大");
        else
            System.out.println("c2半径大");
        int compareValue2= c1.compareTo(c3);
        if(compareValue2>0)
            System.out.println("c1半径大");
        else if(compareValue2==0)
            System.out.println("一样大");
        else
            System.out.println("c3半径大");
        int compareValue3= c1.compareTo(c4);
        if(compareValue3>0)
            System.out.println("c1半径大");
        else if(compareValue3==0)
            System.out.println("一样大");
        else
            System.out.println("c4半径大");

    }
}
