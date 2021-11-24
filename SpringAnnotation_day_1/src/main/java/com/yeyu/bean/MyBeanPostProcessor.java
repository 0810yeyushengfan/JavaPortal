package com.yeyu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//后置处理器:在bean对象初始化前后进行工作
//@Configuration//将后置处理器加入到IOC容器中
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行了postProcessBeforeInitialization方法");
        //方法的返回值就是我们将来要用的时候(比如getBean())获取到的bean实例
        //可以返回原来的bean对象，也可以在这里对bean对象进行处理，包装好以后再返回
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行了postProcessAfterInitialization方法");
        return bean;
    }
}
