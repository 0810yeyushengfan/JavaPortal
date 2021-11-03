package test1;

public class Person {
    private int age;
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
/*    public int doAge(int a)千万不要这样写！！这样会搞不懂这个方法的意图，还不如在main中直接输出a
    {
        age=a;
        return age;
    }
*/
}
