package com.yeyu.spring5.test;

import com.yeyu.spring5.aopanno.User;
import com.yeyu.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestAop {

    @Test
    public void testAopAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
