package com.yeyu.Condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否时Linux系统
public class LinuxCondition implements Condition {
    //ConditionContext:判断条件能使用的上下文(环境)
    //AnnotationTypeMetadata:当前标注@Condition注解的类的注解信息
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1.能获取到IOC容器使用的BeanFactory(这个工厂就是IOC容器创建对象以及执行装配的工厂)
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境的信息(当前运行时的信息，环境变量，虚拟机的信息......)
        Environment environment = context.getEnvironment();
        //4.获取到Bean定义的注册类(所有的Bean定义都在BeanDefinitionRegistry类中进行注册)
        BeanDefinitionRegistry registry = context.getRegistry();

        //可以判断容器中的Bean的注册情况，也可以给容器中注册Bean(后面讲)
        //判断容器中是否有id为person的Bean
        boolean person = registry.containsBeanDefinition("person");
        System.out.println(person);
        String property = environment.getProperty("os.name");
        if (property.contains("linux")) {
            //表示满足条件
            return true;
        }
        //表示不满足条件
        return false;
    }
}
