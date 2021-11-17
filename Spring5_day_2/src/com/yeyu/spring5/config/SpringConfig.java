package com.yeyu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//完全注解开发:
//1.@Configuration:
//标记一个类为配置类，用来替代xml配置文件
@Configuration
//2.@ComponentScan:
//开启组件扫描，value的值是一个字符串数组，即扫描的包名
@ComponentScan(value = {"com.yeyu.spring5"})
public class SpringConfig {

}
