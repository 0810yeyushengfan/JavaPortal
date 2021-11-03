package jiangjie2;

public class Student extends Person{
    String major;
    public Student()
    {

    }
    public Student(String major)
    {
        this.major=major;
    }
    public void study()
    {
        System.out.println("学习。专业是"+major);
    }
    public void eat()//对父类的eat方法进行了重写
    {
        System.out.println("学生应该多吃有营养的食物。");
    }
    public void show()
    {
        System.out.println("我是一个学生");
    }
}
