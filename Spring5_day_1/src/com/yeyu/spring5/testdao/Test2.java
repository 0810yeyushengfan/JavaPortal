package com.yeyu.spring5.testdao;

import com.yeyu.spring5.bean.Emp;
import com.yeyu.spring5.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class Test2 {

    @Test
    public void testBean1() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testBean2() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Emp emp = context.getBean("emp1", Emp.class);
        emp.add();
    }
    @Test
    public void testBean3() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Emp emp = context.getBean("emp2", Emp.class);
        emp.add();
    }
    @Test
    public void testBean4() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        Emp emp = context.getBean("emp3", Emp.class);
        emp.add();
    }
}
