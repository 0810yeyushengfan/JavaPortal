package jiangjie3;
/*
javaBean是一种java语言写成的可重用组件。
所谓javabean，，是指符合如下标准的Java类
1.类是公共的
2.有一个无参的公共的构造器
3，有属性，具有对应的get与set方法
 */
public class Customer {
    private int id;
    private String name;
    public Customer()
    {

    }
    public void setId(int i)
    {
        id=i;
    }
    public int getId()
    {
        return id;
    }
    public  void getName(String n)
    {
        name=n;
    }
    public String setName()
    {
        return name;
    }

}
