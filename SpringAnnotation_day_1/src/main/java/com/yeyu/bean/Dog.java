package com.yeyu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {
    public Dog() {
        System.out.println("dog--->constructor");
    }
    //在bean创建完成并且属性赋值完成之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog--->init");
    }
    //在容器销毁bean之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("dog--->destroy");
    }
}