package com.yeyu.spring5.service;

import com.yeyu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
1.什么是注解?
1.1.注解是代码特殊标记，格式:@注解名称(属性名称=属性值, 属性名称=属性值..)
1.2.使用注解:注解作用在类上面，方法上面，属性上面...
1.3.使用注解的目的：简化xml的配置

2.Spring针对Bean管理中创建对象提供的注解:
2.1.@Component:普通组件
2.2.@Service:一般用于service层
2.3.@Controller:一般用于web层
2.4.@Repository:一般用于dao层
这四个注解功能其实是一样的，都可以用来创建bean实例，只是为了开发更加方便提供了多个注解
 */
//在注解里面value属性值的意义和在xml配置的bean中的id相同，value值可以省略不写，默认值是类名称(首字母小写)
//举例:UserService(类名称)-->userService(默认value值)
//举例:@Component(value = "userService")等价于<bean id="userService" class=".."/>
@Service
public class UserService {

    //3.基于注解方式实现属性注入:
    //3.1.@Value:注入普通类型属性
    @Value(value = "abc")
    private String name;

    //3.2.@Autowired:根据属性类型进行自动装配
    //3.2.1.把service和dao对象创建，在service和dao的类中添加创建对象注解
    //3.2.2.在service注入到dao对象中，在service类中添加dao类型属性(不需要为dao属性添加set方法)，在属性上面使用注解@Autowired
    //@Autowired
    //private UserDao userDao;

    //3.3.@Qualifier:根据名称进行注入
    //这个@Qualifier注解需要和上面的@Autowired注解一起使用，当有多个相同类型的对象时，@Autowired会失效，此时通过@Qualifier
    //来指定所注入的对象，value值应该时所注入对象的id值
    //@Autowired
    //@Qualifier(value = "userDaoImpl1")
    //private UserDao userDao;


    //3.4.@Resource:可以根据类型注入，也可以根据名称注入
    //这个注解不是spring的包下的注解，而是javax包下的注解(在jdk11的版本此包被弃用)，因此spring不推荐使用这个注解进行属性注入
    //3.4.1.根据类型进行注入(不指定name属性):
    //@Resource
    //private UserDao userDao;
    //3.4.2.根据名称进行注入(指定name属性)
    @Resource(name = "userDaoImpl1")
    private UserDao userDao;

    public void add() {
        System.out.println("service add......."+name);
        userDao.add();
    }
}
