package com.yeyu.test;

import com.yeyu.bean.Person;
import com.yeyu.config.MainConfig;
import com.yeyu.config.MainConfig2;
import com.yeyu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

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
    public void test6(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test7(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //获取工厂Bean本身
        Object colorFactoryBean = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型"+colorFactoryBean.getClass());
    }

    @Test
    public void test8(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("容器创建完成...");
        classPathXmlApplicationContext.getBean("MyCar");
        //2.手动关闭IOC容器
        classPathXmlApplicationContext.close();
    }

    @Test
    public void test9(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        annotationConfigApplicationContext.getBean("car");
        //2.手动关闭IOC容器
        annotationConfigApplicationContext.close();
    }
    @Test
    public void test10() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
    }


}
