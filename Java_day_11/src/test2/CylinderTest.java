package test2;

import java.util.concurrent.Callable;

public class CylinderTest {
    public static void main(String[] args) {
       Cylinder cy=new Cylinder();
       cy.setLength(3.4);
       cy.setRadius(2.1);
       double volumn= cy.findVolume();
       System.out.println("圆柱的体积为"+volumn);
       double area=cy.findArea();
       System.out.println("圆的面积为"+area);
       System.out.println("******************");
       Cylinder cy1=new Cylinder();
        double volumn1= cy1.findVolume();
        System.out.println("圆柱的体积为"+volumn1);
        double area1=cy1.findArea();
        System.out.println("圆的面积为"+area1);

    }
}
