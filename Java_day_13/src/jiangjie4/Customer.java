package jiangjie4;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }


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



    //重写的原则:比较两个对象的实体内容（即name和id）是否相同.
    public boolean eauqls(Object obj) {
            if (this == obj)
                return true;
            if (obj instanceof Customer)//判断是否是Customer类型的，如果不是，就放回false，只有是Customer才能继续比较
            {
                Customer cust = (Customer) obj;
                //比较两个对象的每种属性是否相等
                if (this.id == cust.id && this.name.equals(cust.name))
                {
                    return true;
                }
                else
                {
                    return false;
                }
                //或者 return this.id == cust.id && this.name.equals(cust.name)
            }
            return false;
    }



    //自动生成的重写过的equals（）方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }
    //手动实现的重写的toString方法
    //public String toString()
    //{
    //   return "Customer[name = "+name+",age = "+id+"]";
    //}
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}