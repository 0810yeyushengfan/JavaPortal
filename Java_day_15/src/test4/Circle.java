package test4;
/*
定义一个Circle类，声明redius属性，提供getter和setter方法
 */
public class Circle {
    double redius;

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }

    public Circle() {
    }

    public Circle(double redius) {
        this.redius = redius;
    }
}
