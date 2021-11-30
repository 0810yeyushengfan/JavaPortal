package com.yeyu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    public ApplicationContext applicationContext;

    //参数为当前Bean对象所在的IOC容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的IOC容器为" + applicationContext);
        this.applicationContext = applicationContext;
    }

    //参数为当前Bean对象的id,在IOC容器创建对象之后回调
    @Override
    public void setBeanName(String s) {
        System.out.println("当前Bean的id为" + s);
    }

    //参数为IOC容器中解析字符串的解析器，可以用来解析上面提到的SpEL和引入外部配置文件的语句等
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("当前系统是${os.name}，它现在#{0.5*2}岁了");
        System.out.println(s);
    }
}
