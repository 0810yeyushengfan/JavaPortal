package jiangjie6;

public class Animals {
    String name;
    int age;
    private int legs;
    public void eat()
    {
        System.out.println("动物进食");
    }
    public  void show()
    {
        System.out.println("name="+name+" legs="+legs+" age"+age);
    }
    public void setLegs(int l)
    {
        if(l>=0&&l%2==0)
        {
            legs=l;
        }
        else
        {
            legs=0;
            //抛出一个异常（暂时未讲）
        }
    }
    public void setAge(int a)//是封装性的一个体现，不等同于封装性
    {
        age=a;
    }
    public int  getAge()//是封装性的一个体现，不等同于封装性
    {
        return age;
    }

}
