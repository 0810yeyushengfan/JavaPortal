package jiangjie4;

public class Person {
    private int age;
    private String name;
    public Person()
    {
        System.out.println("Person初始化时，需要考虑如下的1,2,3,4....(共40行代码)");
    }
    public Person(int age)
    {
        this();
        this.age=age;
        //System.out.println("Person初始化时，需要考虑如下的1,2,3,4....(共40行代码)");因为this（）代替了这个功能
    }
    public Person(String name)
    {
        this();
        this.name=name;
        //System.out.println("Person初始化时，需要考虑如下的1,2,3,4....(共40行代码)");因为this（）代替了这个功能
    }
    public Person(String name,int age)
    {
        this(age);
        this.name=name;
        //this.age=age;
        //System.out.println("Person初始化时，需要考虑如下的1,2,3,4....(共40行代码)");因为this（age）代替了这两个功能
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public int getAge()
    {
        return age;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void eat()
    {
        System.out.println("人吃饭！\n");
    }
}
