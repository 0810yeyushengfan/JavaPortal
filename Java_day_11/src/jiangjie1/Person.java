package jiangjie1;

public class Person extends Creature{
    String name;
    private int age;
    public Person()
    {

    }
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void eat()
    {
        System.out.println("吃饭!");
        this.sleep();
    }
    private void sleep()
    {
        System.out.println("睡觉!");
    }
    public void setAge(int a)
    {
        age=a;
    }
    public  int getAge()
    {
        return age;
    }
}
