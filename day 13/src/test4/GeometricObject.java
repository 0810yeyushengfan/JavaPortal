package test4;

public class GeometricObject {
    private String color;
    private double weight;
    public GeometricObject()//初始化对象的color属性为“white”，weight 属性为1.0
    {
        super();
        this.color="white";
        this.weight=1.0;
    }
    public GeometricObject(String color, double weight) {
        super();
        this.color = color;
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
