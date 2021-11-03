package jiangjie5;

public class Student extends Person{
    String major;
    int id=1002;//身份证号
    public Student()
    {
        System.out.println("我无处不在！");
    }
    public Student(String major)
    {
        this.major=major;
    }
    public Student(String name,int age,String major)
    {
        super(name,age);
        this.major=major;

    }
    public void eat()
    {
        System.out.println("学生多吃有营养的食物");
    }
    public void study()
    {
        System.out.println("学生学习知识");
        eat();
        this.eat();
        super.eat();
    }
    public void show()
    {
        System.out.println("name= "+name+", age="+age);//先在当前的子类当中找属性，没有找到时才去父类中找
        System.out.println("id="+this.id);//直接找子类的id属性
        System.out.println("id="+super.id);//直接找父类的id属性
    }
}
