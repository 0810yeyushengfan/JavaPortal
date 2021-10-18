package test1;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1=new Circle();
        Circle c2=new Circle();
        Circle c3=new Circle();
        System.out.println("c1的id为 "+c1.getId());
        System.out.println("c2的id为 "+c2.getId());
        System.out.println("创建的圆的个数为 "+Circle.getTotal());
        System.out.println("c3的id为 "+c3.getId());

    }
}
