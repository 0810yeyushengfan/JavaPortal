package com.yeyu.bean;

public class Car {
    public Car() {
        System.out.println("car--->constructor");
    }

    public void destroy(){
        System.out.println("car--->destroy");
    }

    public void init(){
        System.out.println("car--->init");
    }
}
