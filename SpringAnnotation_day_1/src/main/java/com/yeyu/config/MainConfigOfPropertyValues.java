package com.yeyu.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用@PropertySource读取外部配置文件并转化为键值对形式保存到运行的环境变量中
@PropertySource(value = "classpath:/Person.properties")
@Configuration
@ComponentScan("com.yeyu")
public class MainConfigOfPropertyValues {

}
