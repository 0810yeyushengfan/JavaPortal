package com.yeyu.config;

import com.yeyu.bean.Person;
import org.springframework.context.annotation.Configuration;

/*
type属性能取的属性值:
①.FilterType.ANNOTATION:按照注解类型过滤
②.FilterType.ASSIGNABLE_TYPE:按照给定的类过滤
③.FilterType.ASPECTJ:使用ASPECTJ表达式过滤
④.FilterType.REGEX:使用正则表达式过滤
⑤.FilterType.CUSTOM:使用自定义的过滤规则，使用时classes属性的属性值必须是TypeFilter接口的实现类
 */
@Configuration//告诉Spring这是一个配置类，用来代替以前的xml形式的配置文件
//@ComponentScans
//(@ComponentScan(value = {"com.yeyu"}, excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
//}))
//在jdk8的时候，@ComponentScan变成了重复注解，可以在一个配置类上单独标注多次
//@ComponentScan(value = "com.yeyu.Controller")
//@ComponentScan(value = "com.yeyu.Dao")
public class MainConfig {
    //给Spring容器注册一个Bean，Bean的类型为方法返回值的类型，Bean的id为方法的名称。
    //@Bean(value = "BeanPerson")//添加参数value，为Bean指定id
    public Person MyPerson() {
        return new Person("黄少天", 20);
    }
}
