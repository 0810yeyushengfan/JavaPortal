package test4;

public class Circle extends GeometricObject{
    private double radius;

    public Circle() {//初始化对象的color属性为“white”，weight属性 为1.0，radius属性为1.0。
        super();
        radius=1.0;
    }

    public Circle(double radius) {//初始化对象的color属性 为“white”，weight属性 为1.0，radius根据参数 构造器确定。
        super();
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea()//计算圆的面积
    {
        return Math.PI*radius*radius;
    }
    public boolean equals(Object obj){//重写equals方法,比较两个圆的半径是否相等，如相等，返回true。
        if(this==obj)
            return true;
        if(obj instanceof Circle)
        {
            Circle c=(Circle) obj;
            return c.radius==this.radius;
        }
        return false;
    }
    public String toString(){//重写toString方法,输出圆的半径。
        return "Circle [radius="+radius+"]" ;
    }
}
