package jiangjie1;

public class Student extends Person{
//    String name;
//    int age;
    String major;
    public Student()
    {

    }
    public Student(String name,int age,String major)
    {
        this.name=name;
        this.setAge(age);
        this.major=major;
    }
//    public void eat()
//    {
//        System.out.println("吃饭!");
//    }
//    public void sleep()
//    {
//        System.out.println("睡觉!");
//    }
    public void study()
    {
        System.out.println("学习!");
    }
}
