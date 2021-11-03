package Practise9;
/*
编写两个类，TriAngle和TriAnTest，其中Triangle类中声明私有的底边长base和高height，
同时声明公共方法访问私有变量，此外，提供类必要的构造器。
另一个类中使用这些公共方法，计算三角形的面积
 */
public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1=new TriAngle();
        t1.setBase(2.0);
        t1.setHeight(2.4);
//不能用t1.base=2.0;t1.height=2.4;
        System.out.println("base : "+t1.getBase()+"\n"+"height : "+t1.getHeight()+"\n"+"area : "+t1.getBase()*t1.getHeight()/2);
        TriAngle t2=new TriAngle(5.1,5.6);
        System.out.println("base : "+t2.getBase()+"\n"+"height : "+t2.getHeight()+"\n"+"area : "+t2.getBase()*t2.getHeight()/2);
    }
}
