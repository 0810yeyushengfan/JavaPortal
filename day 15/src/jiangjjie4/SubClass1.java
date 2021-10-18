package jiangjjie4;

public class SubClass1 extends SuperClass implements CompareA,CompareB {
    public void method3(){
        System.out.println("SublClass1:深圳");
    }
    //知识点5:如何在子类（或实现类）的方法中调用父类，接口中被重写的方法
    public void myMethod(){
        method3();//调用自己定义的重写的方法
        super.method3();//调用的是父类中声明的方法
        //调用接口中的默认方法
        CompareA.super.method3();
        CompareB.super.method3();
    }
}
