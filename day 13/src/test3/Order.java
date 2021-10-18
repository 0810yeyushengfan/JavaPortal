package test3;

import com.sun.org.apache.xpath.internal.operations.Or;

/*
1.编写Order类，有int型的orderId，String型的orderName，相应的getter()和setter()方法，两个参数的构造器，
  重写父类的equals()方法：public boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等。
 */
public class Order {
    private int orderId;
    private String orderName;
    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public boolean equals(Object obj)//正确的重写方法
    {
        if(this==obj)
            return true;
        if(obj instanceof Order)
        {
            Order order=(Order) obj;
            return this.orderId==order.orderId&&this.orderName.equals(order.orderName);
        }
        return false;
    }
    /*public boolean equals(Object obj)错误的重写方法，这启发我们只要涉及到引用数据类型的判断实体内容是否相等的问题，
      都要用equals（）方法，不能用==。同样的，若在本类型的equals（）方法中，要比较其他自定义的类型（的实体内容是否相等），
      也要重写出其他自定义的类型的equals（）方法，并在本类型 的equals（）方法中调用。
    {
        if(this==obj)
            return true;
        if(obj instanceof Order)
        {
            Order order=(Order) obj;
            return this.orderId==order.orderId&&this.orderName==order.orderName;
        }
        return false;
    }
      */


}
