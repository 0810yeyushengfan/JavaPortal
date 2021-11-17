package com.yeyu.spring5.aopanno;

import org.springframework.stereotype.Component;

//被增强的类
@Component
public class User {
    public void add() {
        //模拟出现运行时异常的情况
        //int i = 10/0;
        System.out.println("add.......");
    }
}
