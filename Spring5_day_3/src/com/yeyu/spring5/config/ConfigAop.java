package com.yeyu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//完全使用注解开发
@Configuration
@ComponentScan(basePackages = {"com.yeyu"})
//@EnableAspectJAutoProxy:开启Aspect，生成代理对象，默认不开启这个注解，添加这个注解后默认proxyTargetClass为false，需要设置为true才能生效
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
