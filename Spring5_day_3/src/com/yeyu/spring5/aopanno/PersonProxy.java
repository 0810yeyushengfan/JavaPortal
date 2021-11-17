package com.yeyu.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(数字类型值):有多个增强类对同一个方法进行增强，设置增强类优先级，数字类型值越小优先级越高
@Order(1)
public class PersonProxy {
    //@Before:后置通知(返回通知)
    @Before(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person Before.........");
    }
}
