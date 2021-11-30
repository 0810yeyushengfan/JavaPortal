package com.yeyu.test;

import com.yeyu.aop.MathCalculator;
import com.yeyu.bean.*;
import com.yeyu.config.*;
import com.yeyu.service.BookService;
import com.yeyu.tx.TxConfig;
import com.yeyu.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;
import java.util.Map;

public class MainTest {

    @Test
    public void test1() {
        //ClassPathXmlApplicationContext翻译为xml配置文件类路径应用上下文
        //参数是配置文件位置的字符串
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) classPathXmlApplicationContext.getBean("MyPerson");
        System.out.println(person);
    }

    @Test
    public void test2() {
        //AnnotationConfigApplicationContext翻译为注解配置应用上下文
        // 参数是配置类的本身的对象
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("BeanPerson");
        System.out.println(person);
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        //BookController bookController = (BookController) annotationConfigApplicationContext.getBean("bookController");
        //System.out.println(bookController);
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person beanPerson1 = (Person) annotationConfigApplicationContext.getBean("BeanPerson");
        Person beanPerson2 = (Person) annotationConfigApplicationContext.getBean("BeanPerson");
        System.out.println(beanPerson1 == beanPerson2);
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        //从环境上下文中获取当前环境的信息
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        //在当前环境的信息中动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
        //在环境上下文中根据类型获取指定类型的Bean对象的map并遍历，键是Bean对象的id，值是Bean对象
        Map<String, Person> beansOfType = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test7() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //获取工厂Bean本身
        Object colorFactoryBean = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型" + colorFactoryBean.getClass());
    }

    @Test
    public void test8() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("容器创建完成...");
        classPathXmlApplicationContext.getBean("MyCar");
        //2.手动关闭IOC容器
        classPathXmlApplicationContext.close();
    }

    @Test
    public void test9() {
        //1.创建IOC容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        annotationConfigApplicationContext.getBean("car");
        //2.手动关闭IOC容器
        annotationConfigApplicationContext.close();
    }

    @Test
    public void test10() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
        //配置文件的值被加载后也能在环境变量中获取
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println("在环境变量中key为person.nickName的value为" + property);
    }

    @Test
    public void test11() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        BookService bookService = (BookService) annotationConfigApplicationContext.getBean("bookService");
        //验证@Autowired是不是在找到多个相同类型的组件的时候，将属性的名称作为组件的id去IOC容器中查找
        bookService.print();
        Object bookDao = annotationConfigApplicationContext.getBean("bookDao");
        //验证在bookService中注入的bookDao是否是IOC容器中的bookDao
        System.out.println(bookDao.hashCode() == bookService.bookDao.hashCode());
    }

    @Test
    public void test12() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        BookService bookService = (BookService) annotationConfigApplicationContext.getBean("bookService");
        //验证bookDao属性是否为空
        System.out.println(bookService);
    }

    @Test
    public void test13() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        BookService bookService = (BookService) annotationConfigApplicationContext.getBean("bookService");
        //验证@Primary是否起作用，bookService对象中是否被注入了bookDao2对象而非默认的bookDao对象
        bookService.print();
    }

    @Test
    public void test14() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        Boss boss = (Boss) annotationConfigApplicationContext.getBean("boss");
        System.out.println(boss);
        Car car = (Car) annotationConfigApplicationContext.getBean("car");
        //验证在boss中注入的car是否是IOC容器中的car
        System.out.println(car == boss.getCar());
    }


    @Test
    public void test15() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        Color color = (Color) annotationConfigApplicationContext.getBean("color");
        System.out.println(color);
        Car car = (Car) annotationConfigApplicationContext.getBean("car");
        //验证在color中注入的car是否是IOC容器中的car
        System.out.println(car == color.getCar());
    }

    @Test
    public void test16() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
        Red red = (Red) annotationConfigApplicationContext.getBean("red");
        //验证在red中注入的applicationContext是不是IOC容器本身
        System.out.println(red.applicationContext == annotationConfigApplicationContext);
    }

    //1.使用命令行动态参数:在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2.代码的方式激活某种环境；
    @Test
    public void test17() {
        //1.使用空参构造器创建一个AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //2.在创建的AnnotationConfigApplicationContext中设置需要激活的环境
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");
        //3.在创建的AnnotationConfigApplicationContext中注册主配置类
        annotationConfigApplicationContext.register(MainConfigOfProfile.class);
        //4.启动并刷新创建的AnnotationConfigApplicationContext容器
        annotationConfigApplicationContext.refresh();
        for (String s : annotationConfigApplicationContext.getBeanNamesForType(DataSource.class)) {
            System.out.println(s);
        }
    }

    @Test
    public void test18() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        //不要自己创建对象，AOP针对的只是从IOC容器中获取的对象
        //MathCalculator mathCalculator = new MathCalculator();
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);
        //手动模拟异常出现
        //mathCalculator.div(1, 0);
        applicationContext.close();
    }

    @Test
    public void test19() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        userService.insertUser();
        annotationConfigApplicationContext.close();

    }

}
