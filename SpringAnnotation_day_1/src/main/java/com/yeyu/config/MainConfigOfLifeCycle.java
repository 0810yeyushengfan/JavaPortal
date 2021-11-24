package com.yeyu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.yeyu")
@Configuration
public class MainConfigOfLifeCycle {
//    @Bean(initMethod="init",destroyMethod="destroy")
//    public Car car(){
//        return new Car();
//    }
}
