package com.yeyu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加载IOC容器中的组件在IOC容器启动时会默认调用组件的无参构造器创建对象，再进行初始化赋值操作
//默认加载IOC容器中的组件在IOC容器启动时会默认调用组件的无参构造器创建对象，再进行初始化赋值操作
@Component
public class Boss {
    private Car car;

    public Boss() {
    }

    //构造器要用的组件，都能够从容器中获取

    public Car getCar() {
        return car;
    }

    public Boss(@Autowired Car car) {
        this.car = car;
    }

    public void setCar(@Autowired Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}