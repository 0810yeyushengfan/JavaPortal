package com.yeyu.spring5.testdao;


import com.yeyu.spring5.bean.Book;
import com.yeyu.spring5.bean.Orders;
import com.yeyu.spring5.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/*
1.什么是IOC
1.1.控制反转，把对象创建和对象之间的调用过程交给Spring进行管理
1.2.使用IOC的目的:为了降低耦合度
2.IOC的底层原理:
2.1.xml解析
2.2.工厂模式
2.3.反射
3.IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
4.Spring提供IOC容器实现两种方式(两个接口):
4.1.BeanFactory:IOC容器的基本实现，是Spring内部的使用接口，不提供开发人员进行使用
特点:加载配置文件时候不会创建对象，在获取(使用)对象才去创建对象
4.2.ApplicationContext:BeanFactory接口的子接口，提供更多更强大的功能，一般由开发人员进行使用
特点:加载配置文件时候就会把在配置文件对象进行创建
 */
public class Test1 {

    @Test
    public void testUser() {
        //1.加载spring配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook1() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Book book = context.getBean("book1", Book.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testOrders() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.ordersTest();
    }

    @Test
    public void testBook2() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Book book = context.getBean("book2", Book.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testBook3() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Book book = context.getBean("book3", Book.class);
        System.out.println(book);
        book.testDemo();
    }
}
