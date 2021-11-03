package jiangjie6;
/*
instanceof用于判断测试左边的对象是否是右边类创建的实例对象，在使用中需要以下注意几点:
1.类的实例包括本身的实例，以及所有直接或间接子类的实例，也就是说若当B是A的子类时，B的对象b instanceof A，也返回true。
2.instanceof左边显式声明的类型与右边操作元必须是同种类或存在继承关系，也就是说需要位于同一个继承树，否则会编译错误。
3.null与任何引用类型进行instanceof对比的结果都是 false，null不属于任何类型，更不属于object基类的派生类（子类），
 */
public class InstanceofTest {
    public static void main(String[] args) {

        // Object > Person > Woman
        // Object > Person > Man>Boy
        // Object > String
        Object o = new Man(); // 主要看这个对象是什么类型与实例化的类名
        // instanceof关键字可以判断左边对象是否是右边类或者子类的一个实例
        System.out.println(o instanceof Man); //true o 是Student类的一个实例对象 所以判断右边类跟student有无关系 以及显示声明有无关系
        System.out.println(o instanceof Person); // true
        System.out.println(o instanceof Object); // true
        System.out.println(o instanceof String); // false
        System.out.println(o instanceof Woman); // false
        System.out.println("========================");
        Person person = new Man();
        System.out.println(person instanceof Person); // true
        System.out.println(person instanceof Object); // true
        // System.out.println(person instanceof String); // 编译错误
        System.out.println(person instanceof Woman); // false
        Person boy=new Boy();
        System.out.println(boy instanceof Man);//true
        Man b=(Man)boy;//相当于多态了一次
        b.eat();

    }
}
