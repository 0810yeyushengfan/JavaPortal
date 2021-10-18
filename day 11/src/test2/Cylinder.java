package test2;

public class Cylinder extends Circle{
    private double length;
    public Cylinder()
    {
        length=1.0;
    }
    public void setLength(double length)
    {
        this.length=length;
    }
    public double getLength()
    {
        return length;
    }
    public double findVolume()
    {
        return findArea()*getLength();
    }
}
