package jiangjie1;

public class Person {
    //属性
    String name;
    int age;
    //构造器
    public Person()
    {
        System.out.println("Person()........");
    }
    public Person(String n)
    {
        name=n;
    }
    public Person(String n,int a)
    {
        name=n;
        age=a;
    }
    //方法
    public void eat()
    {
        System.out.println(name+"不吃饭了！");
    }

}
