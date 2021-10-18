package test2;
public class Person {
    private int age;
    private  String name;
    public Person()
    {
        age=18;
    }
    public Person(String n,int a)
    {
        name=n;
        age=a;
    }
    public Person(String n)
    {
        name=n;
    }
    public void setAge(int a)
    {
        if(a<0||a>130)
        {
//          throw new RuntimeException("传入的数据非法！");
            System.out.println("传入的数据非法！");
            return;
        }
        age=a;
    }
    public int getAge()
    {
        return age;
    }
    public void setName(String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
}
