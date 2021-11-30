package com.yeyu.config;

import com.yeyu.dao.BookDao;
import com.yeyu.bean.Car;
import com.yeyu.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.yeyu")
@Configuration
public class MainConfigOfAutoWired {

    //设为同类型的首选Bean
    @Bean
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLable(2);
        return bookDao;
    }

    //@Bean标注的方法创建对象的时候，方法参数的值如果是自定义类型的值，就能自动从IOC容器中获取，相当于给参数加上了@Autowired注解
    @Bean
    public Color color(Car car){
        Color color= new Color();
        color.setCar(car);
        return color;
    }

//    @Bean
//    public Red red2(){
//        return new Red();
//    }
}
