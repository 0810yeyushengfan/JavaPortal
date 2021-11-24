package com.yeyu.config;

import com.yeyu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    //BeanDefinitionRegistry:Bean定义的注册类(所有的Bean定义都在BeanDefinitionRegistry类中进行注册)
    //所有需要添加到容器中的Bean都可以调用BeanDefinitionRegistry的registerBeanDefinition()方法进行注册
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.yeyu.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.yeyu.bean.Blue");
        if(red && blue){
            //指定注册Bean的类型
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //指定注册Bean的id
            registry.registerBeanDefinition("MyRaindow",rootBeanDefinition);
        }
    }
}
