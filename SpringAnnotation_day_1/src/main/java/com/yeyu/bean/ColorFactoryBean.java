package com.yeyu.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //对象是否是单例，返回true是单例，返回false是多例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
