package test1;

/*
编写一个Employee类，声明为抽象类，包含如下三个属性：name，id，salary。提供必要的构造器和抽象方法：work()。
对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。
 */
public class EmployeeTest {
    public static void main(String[] args) {
        //多态
        Employee manager=new Manager("库克",1001,5000,50000);
        manager.work();
        CommonEmployee commonEmployee=new CommonEmployee();
        commonEmployee.work();
    }
}
