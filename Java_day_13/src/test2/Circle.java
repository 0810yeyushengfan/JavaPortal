package test2;

public class Circle extends GeometricObject{
    private double radius;
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



    public Circle() {
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }
    public double findArea()
    {
        return Math.PI*radius*radius;
    }
}
