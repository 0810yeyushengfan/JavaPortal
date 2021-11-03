package jiangjjie4;

public class SubClassTest{
    public static void main(String[] args) {
        SubClass s=new SubClass();
        //s.method1();
        //SubClass.method1();
        //知识点1:接口中定义的静态方法，只能通过接口来调用
        CompareA.method1();
        //知识点2:通过实现类的对象，可以调用接口中的默认方法
        //如果实现类重写了接口中的默认方法，调用时，仍然调用的时重写以后的默认方法，即实现类的默认方法
        s.method2();
        //SubClass.method2();
        //知识点3:如果子类（或实现类）继承的父类和实现的接口中定义了同名同参数的方法。
        //那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。--->类优先原则
        s.method3();
        //知识点4:如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
        //那么在实现类没有重写此方法的情况下，编译器会报错--->接口冲突。
        //这就需要我们必须在实现类中重写此方法。
        SubClass1 s1=new SubClass1();
        s1.method3();
    }

}
