package com.yeyu.spring5.testdao;


import com.yeyu.spring5.bean.Orders2;
import com.yeyu.spring5.collectiontype.Book;
import com.yeyu.spring5.collectiontype.Course;
import com.yeyu.spring5.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    @Test
    public void testCollection1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
        System.out.println(course.getClass());
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        com.yeyu.spring5.bean.Book book1 = context.getBean("book4",com.yeyu.spring5.bean.Book.class);
        com.yeyu.spring5.bean.Book book2 = context.getBean("book4",com.yeyu.spring5.bean.Book.class);
        com.yeyu.spring5.bean.Book book3 = context.getBean("book1",com.yeyu.spring5.bean.Book.class);
        com.yeyu.spring5.bean.Book book4 = context.getBean("book1",com.yeyu.spring5.bean.Book.class);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book1==book2);
        System.out.println(book3==book4);
    }

    @Test
    public void test3() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders2 orders = context.getBean("orders2", Orders2.class);
        System.out.println("第四步:获取创建bean实例对象");
        System.out.println(orders);
        //手动让bean实例销毁
        context.close();
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        com.yeyu.spring5.autowire.Emp emp1 = context.getBean("emp4", com.yeyu.spring5.autowire.Emp.class);
        com.yeyu.spring5.autowire.Emp emp2 = context.getBean("emp5", com.yeyu.spring5.autowire.Emp.class);
        System.out.println(emp1);
        System.out.println(emp2);
    }



}
