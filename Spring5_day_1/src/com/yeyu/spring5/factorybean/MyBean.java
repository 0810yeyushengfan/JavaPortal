package com.yeyu.spring5.factorybean;

import com.yeyu.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

//FactoryBean的泛型类型指定为返回bean的类型
public class MyBean implements FactoryBean<Course> {

    //这个方法用来定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
