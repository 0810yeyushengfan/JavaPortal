package com.yeyu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.yeyu")
//表示对配置类中的组件进行统一设置，满足当前条件时，这个类中配置的所有Bean的注册才能生效
//@Conditional({WindowsCondition.class})
//@Import(value = {Color.class, Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
//    @Lazy
//    @Scope(value = "singleton")//prototype:多实例的
//    @Bean(value = "BeanPerson")//添加参数value，为Bean指定id
//    public Person MyPerson() {
//        System.out.println("创建对象!!!");
//        return new Person("黄少天", 20);
//    }

    //@Conditional:按照一定的条件进行判断,满足条件时才会给IOC容器中注册Bean
    //如果系统是Windows，给容器注册bill，如果是Linux系统，给容器注册linus
//    @Bean
//    public Person bill(){
//        return new Person("Bill Gates",62);
//    }
//
//    @Bean
//    @Conditional({LinuxCondition.class})
//    public Person linus(){
//        return  new Person("linus",48);
//    }

//    @Bean
//    public ColorFactoryBean colorFactoryBean(){
//        return new ColorFactoryBean();
//    }


}
