package test1;

public class Circle {
    private double radius;
    private int id;
    private static int total;//记录创建圆的个数
    private static int init=1001;//static声明的属性被所以对象共享
    public Circle(){
        id=init++;
        total++;
    }
    public Circle(double radius){
        this();
        this.radius=radius;
        //id=init++;
        //total++;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static int getTotal() {
        return total;
    }


    public double findArea()
    {
        return Math.PI*radius*radius;
    }
}
